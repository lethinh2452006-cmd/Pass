package com.thinh.pas.services.impl.category;

import com.thinh.pas.domain.dtos.category.GetAllCategoryRespondDto;
import com.thinh.pas.domain.entities.category;
import com.thinh.pas.domain.reponse.category.GetAllCategoryRespond;
import com.thinh.pas.mapper.CategoryMapper;
import com.thinh.pas.repositories.CategoryRepository;
import com.thinh.pas.services.usecase.categoryusecase.UsecaseGetAllCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllCategoryServiceImpl implements UsecaseGetAllCategory {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public List<GetAllCategoryRespondDto> GetAllCategoryService(){
        List<category> categoryList =categoryRepository.findAll();
        List<GetAllCategoryRespond> repondlists = categoryMapper.toGetAllCategoryRepondList(categoryList);

        return categoryMapper.toDtoRepondList(repondlists);

    }

}
