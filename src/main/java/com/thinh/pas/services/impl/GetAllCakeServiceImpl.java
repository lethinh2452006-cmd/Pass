package com.thinh.pas.services.impl;

import com.thinh.pas.domain.reponse.GetAllCakeReponse;
import com.thinh.pas.domain.requests.GetAllCakeRequest;
import com.thinh.pas.repositories.CakeRepository;
import com.thinh.pas.repositories.UserRepository;
import com.thinh.pas.services.usecase.UsecaseGetAllCakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetAllCakeServiceImpl implements UsecaseGetAllCakeService {
    private final CakeRepository cakeRepository;
    private final UserRepository userRepository;


    @Override
    public GetAllCakeReponse GetAllCake(GetAllCakeRequest getAllCakeRequest) {

        String sortByField = getAllCakeRequest.getSortBy();
        Sort.Direction direction = "asc".equals(getAllCakeRequest.getOrder())
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(getAllCakeRequest.getPage(),
                getAllCakeRequest.getLimit(),
                Sort.by(direction, sortByField)
        );
        return null;
    }
}
