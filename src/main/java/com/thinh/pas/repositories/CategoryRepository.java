public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findAllById(UUID categoryId);
}