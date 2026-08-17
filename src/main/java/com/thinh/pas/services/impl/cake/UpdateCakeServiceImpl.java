package com.thinh.pas.services.impl.cake;

import com.thinh.pas.domain.dtos.UpdateCakeReponseDto;
import com.thinh.pas.domain.dtos.UpdateCakeRequestDto;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.entities.users;
import com.thinh.pas.exceptions.CakeException;
import com.thinh.pas.exceptions.UserNotFoundException;
import com.thinh.pas.mapper.CakeMapper;
import com.thinh.pas.repositories.CakeRepository;
import com.thinh.pas.repositories.UserRepository;
import com.thinh.pas.services.usecase.UsecaseUpdateCakeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCakeServiceImpl implements UsecaseUpdateCakeService {
    private final UserRepository userRepository;
    private final CakeRepository cakeRepository;
    private final CakeMapper cakeMapper;

    @Override
    public UpdateCakeReponseDto UpdateCakeService(UUID user_id, UUID cake_id, @Valid UpdateCakeRequestDto updateCakeRequest){
        users user = userRepository.findById(user_id)
                .orElseThrow(()-> new UserNotFoundException(String.format("User with ID '%s' not found", user_id))
                );

        cakes Cake = cakeRepository.findById(cake_id).orElseThrow(()-> new CakeException());

        Cake.update(
                updateCakeRequest.getNamecake(),
                updateCakeRequest.getDescription(),
                updateCakeRequest.getImage()
                );
        cakes updatecake = cakeRepository.save(Cake);

        return cakeMapper.toUpdateReponse(updatecake);
    }

}
