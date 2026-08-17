package com.thinh.pas.services.usecase.categoryusecase;
import com.thinh.pas.domain.dtos.category.GetAllCategoryRespondDto;
import com.thinh.pas.domain.reponse.category.GetAllCategoryRespond;

import java.util.List;

public interface UsecaseGetAllCategory {
    List<GetAllCategoryRespondDto> GetAllCategoryService();
}