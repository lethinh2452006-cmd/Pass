package com.thinh.pas.services.impl.cake;

import com.thinh.pas.domain.dtos.GetAllCakeReponseDto;
import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.reponse.GetAllCakeReponse;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import com.thinh.pas.domain.requests.GetAllCakeRequest;
import com.thinh.pas.mapper.CakeMapper;
import com.thinh.pas.repositories.CakeRepository;
import com.thinh.pas.services.usecase.UsecaseGetAllCakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllCakeServiceImpl implements UsecaseGetAllCakeService {
    private final CakeRepository cakeRepository;
    private final CakeMapper cakeMapper;

    @Override
    public GetAllCakeReponseDto GetAllCake(GetAllCakeRequest getAllCakeRequest) {
        int page = getAllCakeRequest.getPage() < 1 ? 1 : getAllCakeRequest.getPage();
        int limit = getAllCakeRequest.getLimit() < 1 ? 15 : getAllCakeRequest.getLimit();

        String sortByField = getAllCakeRequest.getSortBy();
        if (sortByField == null || sortByField.isBlank()) {
            sortByField = "createdAt";
        }

        Sort.Direction direction = "asc".equalsIgnoreCase(getAllCakeRequest.getOrder())
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(direction, sortByField));

        Specification<cakes> specification = CakeSpecification.filterCake(getAllCakeRequest);
        Page<cakes> cakePage = cakeRepository.findAll(specification, pageable);

        List<GetCakeReponse> getCakeReponseList = cakePage.getContent().stream()
                .map(cakeMapper::toGetCakeReponse)
                .toList();

        GetAllCakeReponse getAllCakeReponse = new GetAllCakeReponse();
        getAllCakeReponse.setGetCakeReponseList(getCakeReponseList);
        getAllCakeReponse.setPageIndex(page);
        getAllCakeReponse.setPageSize(cakePage.getSize());
        getAllCakeReponse.setTotalElements(cakePage.getTotalElements());
        getAllCakeReponse.setTotalPages(cakePage.getTotalPages());
        getAllCakeReponse.setHasNext(cakePage.hasNext());

        return cakeMapper.toGetAllCakeReponseDto(getAllCakeReponse);
    }
}
