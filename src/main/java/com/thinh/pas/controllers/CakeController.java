package com.thinh.pas.controllers;


import com.thinh.pas.domain.dtos.CreatCakeReponseDto;
import com.thinh.pas.domain.dtos.CreatCakeRequestDto;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.entities.users;
import com.thinh.pas.domain.requests.CreatCakeRequest;
import com.thinh.pas.mapper.CakeMapper;
import com.thinh.pas.services.CakeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/cakes")
@RequiredArgsConstructor
public class CakeController {

    private final CakeMapper cakeMapper;
    private final CakeService cakeService;

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
}
