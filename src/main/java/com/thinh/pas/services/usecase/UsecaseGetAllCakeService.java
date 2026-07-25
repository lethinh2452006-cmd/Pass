package com.thinh.pas.services.usecase;

import com.thinh.pas.domain.reponse.GetAllCakeReponse;
import com.thinh.pas.domain.requests.GetAllCakeRequest;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UsecaseGetAllCakeService {
    GetAllCakeReponse GetAllCake(GetAllCakeRequest getAllCakeRequest);
}
