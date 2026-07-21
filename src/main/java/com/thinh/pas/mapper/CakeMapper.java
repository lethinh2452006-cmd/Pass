package com.thinh.pas.mapper;


import com.thinh.pas.domain.dtos.CreatCakeReponseDto;
import com.thinh.pas.domain.dtos.CreatCakeRequestDto;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.requests.CreatCakeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CakeMapper {

    CreatCakeRequest fromDto(CreatCakeRequestDto CreatCakeRequest);

    CreatCakeReponseDto toDto(cakes cake);
}
