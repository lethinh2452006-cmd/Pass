package com.thinh.pas.services.usecase;

import com.thinh.pas.domain.requests.CreatCakeRequest;
import com.thinh.pas.domain.entities.cakes;

import java.util.UUID;


public interface UsecaseCreatCakeService {
    cakes CreatCakeServive(UUID user_id ,CreatCakeRequest cakeRequest);
}
