package com.thinh.pas.services.impl;

import com.thinh.pas.domain.dtos.GetAllCakeReponseDto;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.reponse.GetAllCakeReponse;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.requests.GetAllCakeRequest;
import com.thinh.pas.domain.requests.GetCakeRequest;
import com.thinh.pas.mapper.CakeMapper;
import com.thinh.pas.repositories.CakeRepository;
import com.thinh.pas.repositories.UserRepository;
import com.thinh.pas.services.usecase.UsecaseGetAllCakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@RequiredArgsConstructor
public class GetAllCakeServiceImpl implements UsecaseGetAllCakeService {
    private final CakeRepository cakeRepository;
    private final UserRepository userRepository;
    private final CakeMapper cakeMapper;


    @Override
    public GetAllCakeReponseDto GetAllCake(GetAllCakeRequest getAllCakeRequest) {
        Specification<cakes> specification = CakeSpecification.filterCake(getAllCakeRequest);
        String sortByField = getAllCakeRequest.getSortBy();
        Sort.Direction direction = "asc".equals(getAllCakeRequest.getOrder())
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(getAllCakeRequest.getPage(),
                getAllCakeRequest.getLimit(),
                Sort.by(direction, sortByField)
        );
        List<GetCakeReponse> listcakes =  cakeRepository.findAll(specification,pageable);
        int Reponsepage = getAllCakeRequest.getPage() + 1;
        GetAllCakeReponse getAllCakeReponse = new GetAllCakeReponse();
        getAllCakeReponse.setGetCakeReponseList(listcakes);
        getAllCakeReponse.setPage_index(Reponsepage);

        return cakeMapper.toGetAllCakeReponseDto(getAllCakeReponse);
    }
}
