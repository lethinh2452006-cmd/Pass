package com.thinh.pas.services;

import com.thinh.pas.domain.CreatCakeRequest;
import com.thinh.pas.domain.entities.cakes;

import java.util.UUID;


public interface CakeService {
    cakes CreatCakeServive(UUID user_id ,CreatCakeRequest cakeRequest);
}
