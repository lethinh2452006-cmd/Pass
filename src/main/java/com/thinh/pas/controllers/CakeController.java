package com.thinh.pas.controllers;


import com.thinh.pas.domain.dtos.CreatCakeReponseDto;
import com.thinh.pas.domain.dtos.CreatCakeRequestDto;
import com.thinh.pas.domain.dtos.GetCakeReponseDto;
import com.thinh.pas.domain.dtos.GetCakeRequestDto;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.requests.CreatCakeRequest;
import com.thinh.pas.domain.requests.GetCakeRequest;
import com.thinh.pas.mapper.CakeMapper;
import com.thinh.pas.services.usecase.UsecaseCreatCakeService;
import com.thinh.pas.services.usecase.UsecaseGetCakeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(path = "/api/v1/cakes")
@RequiredArgsConstructor
public class CakeController {

    private final CakeMapper cakeMapper;
    private final UsecaseCreatCakeService cakeService;
    private final UsecaseGetCakeService getCakeService;

    @PostMapping
    public ResponseEntity<CreatCakeReponseDto> CreatCake(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreatCakeRequestDto creatCakeRequestDto

    ){

        CreatCakeRequest creatCakeRequest = cakeMapper.fromDto(creatCakeRequestDto);
        UUID user_id = UUID.fromString(jwt.getSubject());

        cakes nCake = cakeService.CreatCakeServive(user_id, creatCakeRequest);

        CreatCakeReponseDto creatCakeReponseDto = cakeMapper.toDto(nCake);
        return new ResponseEntity<>(creatCakeReponseDto, HttpStatus.CREATED);
    }


    @GetMapping(value = "/{cake_id}")
    public ResponseEntity<GetCakeReponseDto> GetCake(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable("cake_id") UUID cake_id
    ){
        UUID user_id = UUID.fromString(jwt.getSubject());
        GetCakeRequest getCakeRequest = new GetCakeRequest(cake_id);

        GetCakeReponse getCakeReponse = getCakeService.GetCakeService(user_id, getCakeRequest);

        GetCakeReponseDto getCakeRequestDto1 = cakeMapper.toDto(getCakeReponse);
        return ResponseEntity.status(HttpStatus.OK).body(getCakeRequestDto1);
    }
}
