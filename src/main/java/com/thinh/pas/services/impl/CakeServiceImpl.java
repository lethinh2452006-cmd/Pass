package com.thinh.pas.services.impl;

import com.thinh.pas.domain.requests.CreatCakeRequest;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.entities.users;
import com.thinh.pas.exceptions.UserNotFoundException;
import com.thinh.pas.repositories.CakeRepository;
import com.thinh.pas.repositories.UserRepository;
import com.thinh.pas.services.CakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CakeServiceImpl implements CakeService {

    private final UserRepository userRepository;
    private final CakeRepository cakeRepository;
    @Override
    public cakes CreatCakeServive(UUID user_id, CreatCakeRequest cakeRequest) {
        users user = (users) userRepository.findAllById(user_id)
                .orElseThrow(() ->new UserNotFoundException(String.format("User with ID '%s' not found", user_id))
                );
        cakes Cake = new cakes();

        Cake.setNamecake(cakeRequest.getNamecake());
        Cake.setDescription(cakeRequest.getDescription());
        Cake.setImage(cakeRequest.getImage());

        return cakeRepository.save(Cake);
    }
}
