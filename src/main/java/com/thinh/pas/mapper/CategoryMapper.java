package com.thinh.pas.mapper;

import com.thinh.pas.domain.dtos.category.GetAllCategoryRespondDto;
import com.thinh.pas.domain.entities.category;
import com.thinh.pas.domain.reponse.category.GetAllCategoryRespond;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface CategoryMapper {
    List<GetAllCategoryRespond> toGetAllCategoryRepondList(List<category> categoryList);

    List<GetAllCategoryRespondDto> toDtoRepondList(List<GetAllCategoryRespond> getAllCategoryResponds);
}
