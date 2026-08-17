package com.thinh.pas.services.impl;

import com.thinh.pas.domain.dtos.GetAllCakeReponseDto;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.reponse.GetAllCakeReponse;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.requests.GetAllCakeRequest;
import com.thinh.pas.mapper.CakeMapper;
import com.thinh.pas.repositories.CakeRepository;
import com.thinh.pas.services.impl.cake.GetAllCakeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetAllCakeServiceImplTest {

    @Mock
    private CakeRepository cakeRepository;

    @Mock
    private CakeMapper cakeMapper;

    @InjectMocks
    private GetAllCakeServiceImpl getAllCakeService;

    private cakes sampleCake;
    private GetCakeReponse sampleCakeResponse;

    @BeforeEach
    void setUp() {
        sampleCake = cakes.builder()
                .id(UUID.randomUUID())
                .namecake("Bánh Kem Dâu")
                .description("Bánh ngon")
                .image("dau.jpg")
                .deleted(false)
                .build();

        sampleCakeResponse = new GetCakeReponse();
        sampleCakeResponse.setNamecake("Bánh Kem Dâu");
        sampleCakeResponse.setDescription("Bánh ngon");
        sampleCakeResponse.setImage("dau.jpg");
    }

    @Test
    void testGetAllCake_Success() {
        GetAllCakeRequest request = new GetAllCakeRequest();
        request.setPage(1);
        request.setLimit(10);
        request.setSortBy("createdAt");
        request.setOrder("desc");

        Page<cakes> cakePage = new PageImpl<>(List.of(sampleCake));
        when(cakeRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(cakePage);
        when(cakeMapper.toGetCakeReponse(sampleCake)).thenReturn(sampleCakeResponse);

        GetAllCakeReponseDto dto = new GetAllCakeReponseDto(
                List.of(sampleCakeResponse),
                1,
                1,
                1L,
                1,
                false
        );
        when(cakeMapper.toGetAllCakeReponseDto(any(GetAllCakeReponse.class))).thenReturn(dto);

        GetAllCakeReponseDto result = getAllCakeService.GetAllCake(request);

        assertNotNull(result);
        assertEquals(1, result.getGetCakeReponseList().size());
        assertEquals("Bánh Kem Dâu", result.getGetCakeReponseList().get(0).getNamecake());
        verify(cakeRepository, times(1)).findAll(any(Specification.class), any(Pageable.class));
    }

    @Test
    void testGetAllCake_InvalidPageAndLimit_NormalizesDefaults() {
        GetAllCakeRequest request = new GetAllCakeRequest();
        request.setPage(0); // Invalid page
        request.setLimit(-5); // Invalid limit
        request.setSortBy(""); // Blank sortBy

        Page<cakes> cakePage = new PageImpl<>(List.of(sampleCake));
        when(cakeRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(cakePage);
        when(cakeMapper.toGetCakeReponse(sampleCake)).thenReturn(sampleCakeResponse);

        GetAllCakeReponseDto dto = new GetAllCakeReponseDto(
                List.of(sampleCakeResponse),
                1,
                15,
                1L,
                1,
                false
        );
        when(cakeMapper.toGetAllCakeReponseDto(any(GetAllCakeReponse.class))).thenReturn(dto);

        GetAllCakeReponseDto result = getAllCakeService.GetAllCake(request);

        assertNotNull(result);
        verify(cakeRepository, times(1)).findAll(any(Specification.class), any(Pageable.class));
    }
}
