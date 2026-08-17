package com.thinh.pas.services.impl.cake;

import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.entities.users;
import com.thinh.pas.domain.reponse.DeleteCakeReponse;
import com.thinh.pas.domain.requests.DeleteCakeRequest;
import com.thinh.pas.exceptions.CakeException;
import com.thinh.pas.exceptions.UserNotFoundException;
import com.thinh.pas.repositories.CakeRepository;
import com.thinh.pas.repositories.UserRepository;
import com.thinh.pas.services.usecase.UsecaseDeleteCakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCakeServiceImpl implements UsecaseDeleteCakeService {

    private final CakeRepository cakeRepository;
    private final UserRepository userRepository;

    @Override
    public DeleteCakeReponse DeleteCakeService(UUID user_id, DeleteCakeRequest deleteCakeRequest) {
        users user = userRepository.findAllById(user_id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with ID '%s' not found", user_id)));

        UUID cake_id = deleteCakeRequest.getCake_id();
        cakes cake = cakeRepository.findById(cake_id)
                .orElseThrow(() -> new CakeException(String.format("Cake with ID '%s' not found", cake_id)));

        cake.deleted(true);
        cakeRepository.save(cake);

        return new DeleteCakeReponse("Cake deleted successfully", true);
    }
}
