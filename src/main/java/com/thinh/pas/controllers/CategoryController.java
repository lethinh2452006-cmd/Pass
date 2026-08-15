
@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final UsecaseGetAllCategory usecaseGetAllCategory;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<GetAllCategoryRespondDto>> GetAllCategories() {
        List<Category> categories = usecaseGetAllCategory.GetAllCategoryService();
        List<GetAllCategoryRespondDto> dtos = categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}