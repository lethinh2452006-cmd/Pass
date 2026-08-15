package com.thinh.pas.services.usecase;


import com.thinh.pas.domain.dtos.GetAllCakeReponseDto;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.requests.GetAllCakeRequest;
import org.springframework.data.domain.Page;

public interface UsecaseGetAllCakeService {
    GetAllCakeReponseDto GetAllCake(GetAllCakeRequest getAllCakeRequest);
}
