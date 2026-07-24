package com.thinh.pas.mapper;


import com.thinh.pas.domain.dtos.*;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.reponse.DeleteCakeReponse;
import com.thinh.pas.domain.requests.CreatCakeRequest;
import com.thinh.pas.domain.requests.GetCakeRequest;
import com.thinh.pas.domain.requests.UpdateCakeRequest;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CakeMapper {

    CreatCakeRequest fromDto(@Valid CreatCakeRequestDto CreatCakeRequest);

    CreatCakeReponseDto toDto(cakes cake);

    GetCakeRequest fromDto(@Valid GetCakeRequestDto getCakeRequestDto);

    GetCakeReponseDto toDto(GetCakeReponse getCakeReponse);

    UpdateCakeRequest fromDto(@Valid UpdateCakeRequestDto updateCakeRequestDto);

    UpdateCakeReponseDto toUpdateReponse(cakes cake);

    DeleteCakeReponseDto toDto(DeleteCakeReponse deleteCakeReponse);
}
