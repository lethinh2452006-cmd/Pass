package com.thinh.pas.services.usecase;

import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.requests.GetCakeRequest;

import java.util.UUID;

public interface UsecaseGetCakeService {
    GetCakeReponse GetCakeService(UUID user_id, GetCakeRequest getCakeRequest);
}
