package com.thinh.pas.controllers;

import com.thinh.pas.domain.dtos.category.GetAllCategoryRespondDto;
import com.thinh.pas.domain.reponse.category.GetAllCategoryRespond;
import com.thinh.pas.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thinh.pas.services.usecase.categoryusecase.UsecaseGetAllCategory;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final UsecaseGetAllCategory usecaseGetAllCategory;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<GetAllCategoryRespondDto>> GetAllCategories() {
        List<GetAllCategoryRespondDto> categoriesList = usecaseGetAllCategory.GetAllCategoryService();
        return ResponseEntity.ok(categoriesList);
    }

    
}