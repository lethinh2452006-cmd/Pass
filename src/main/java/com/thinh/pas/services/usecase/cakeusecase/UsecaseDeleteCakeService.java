package com.thinh.pas.services.usecase;

import com.thinh.pas.domain.reponse.DeleteCakeReponse;
import com.thinh.pas.domain.requests.DeleteCakeRequest;

import java.util.UUID;

public interface UsecaseDeleteCakeService {
    DeleteCakeReponse DeleteCakeService(UUID user_id, DeleteCakeRequest deleteCakeRequest);
}
