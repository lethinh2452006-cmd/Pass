package com.thinh.pas.controllers;


import com.thinh.pas.domain.dtos.*;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.requests.CreatCakeRequest;
import com.thinh.pas.domain.requests.GetAllCakeRequest;
import com.thinh.pas.domain.requests.GetCakeRequest;
import com.thinh.pas.mapper.CakeMapper;
import com.thinh.pas.domain.reponse.DeleteCakeReponse;
import com.thinh.pas.domain.requests.DeleteCakeRequest;
import com.thinh.pas.services.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/api/v1/cakes")
@RequiredArgsConstructor
public class CakeController {

    private final CakeMapper cakeMapper;
    private final UsecaseCreatCakeService cakeService;
    private final UsecaseGetCakeService getCakeService;
    private final UsecaseUpdateCakeService updateCakeService;
    private final UsecaseDeleteCakeService deleteCakeService;
    private final UsecaseGetAllCakeService getAllCakeService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
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

    @PutMapping(value = "/{cake_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UpdateCakeReponseDto> UpdateCake(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable("cake_id") UUID cake_id,
            @RequestBody @Valid UpdateCakeRequestDto updatecakerequestdto
    ){
        UUID user_id = UUID.fromString(jwt.getSubject());
        return ResponseEntity.status(HttpStatus.OK).body(updateCakeService.UpdateCakeService(user_id,cake_id,updatecakerequestdto));
    }

    @DeleteMapping(value = "/{cake_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteCakeReponseDto> DeleteCake(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable("cake_id") UUID cake_id
    ){
        UUID user_id = UUID.fromString(jwt.getSubject());
        DeleteCakeRequest deleteCakeRequest = new DeleteCakeRequest(cake_id);
        DeleteCakeReponse deleteCakeReponse = deleteCakeService.DeleteCakeService(user_id, deleteCakeRequest);
        DeleteCakeReponseDto deleteCakeReponseDto = cakeMapper.toDto(deleteCakeReponse);
        return ResponseEntity.status(HttpStatus.OK).body(deleteCakeReponseDto);
    }

    @GetMapping
    public ResponseEntity<GetAllCakeReponseDto> GetAllCakes(
            GetAllCakeRequestDto getAllCakeRequestDto
    ){
        GetAllCakeRequest getAllCakeRequest = cakeMapper.toGetAllCakeRequest(getAllCakeRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(getAllCakeService.GetAllCake(getAllCakeRequest));
    }
}
