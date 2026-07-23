package com.thinh.pas.services.impl;

import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.entities.users;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.requests.GetCakeRequest;
import com.thinh.pas.exceptions.CakeException;
import com.thinh.pas.exceptions.UserNotFoundException;
import com.thinh.pas.repositories.CakeRepository;
import com.thinh.pas.repositories.UserRepository;
import com.thinh.pas.services.usecase.UsecaseGetCakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCakeServiceImpl implements UsecaseGetCakeService {

    private final CakeRepository cakeRepository;
    private final UserRepository userRepository;
    @Override
    public GetCakeReponse GetCakeService(UUID user_id, GetCakeRequest getCakeRequest){
        users user = userRepository.findAllById(user_id)
                .orElseThrow(() ->new UserNotFoundException(String.format("User with ID '%s' not found", user_id))
                );

        UUID cake_id = getCakeRequest.getCake_id();

        cakes cake = cakeRepository.findById(cake_id)
                .orElseThrow(() -> new CakeException(String.format("Cake with ID '%s' not found", cake_id)));
        GetCakeReponse getCakeReponse = new GetCakeReponse();
        getCakeReponse.setNamecake(cake.getNamecake());
        getCakeReponse.setDescription(cake.getDescription());
        getCakeReponse.setImage(cake.getImage());

        return getCakeReponse;
    }
}
