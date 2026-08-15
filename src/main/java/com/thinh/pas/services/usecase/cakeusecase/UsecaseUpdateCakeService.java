package com.thinh.pas.services.usecase;

import com.thinh.pas.domain.dtos.UpdateCakeReponseDto;
import com.thinh.pas.domain.dtos.UpdateCakeRequestDto;
import jakarta.validation.Valid;

import java.util.UUID;

public interface UsecaseUpdateCakeService {
    UpdateCakeReponseDto UpdateCakeService(UUID user_id, UUID cake_id, @Valid UpdateCakeRequestDto updateCakeRequest);
}
