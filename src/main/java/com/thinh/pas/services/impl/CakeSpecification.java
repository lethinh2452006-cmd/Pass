package com.thinh.pas.services.impl;


import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.requests.GetAllCakeRequest;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CakeSpecification {
    public static Specification<cakes> filterCake(GetAllCakeRequest getAllCakeRequest){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if(getAllCakeRequest.getSearch() != null && !getAllCakeRequest.getSearch().isBlank()){

                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + getAllCakeRequest.getSearch().toLowerCase() + "%"
                        )
                );
            }

            if(getAllCakeRequest.getCategoryId() != null){

                predicateList.add(
                        criteriaBuilder.equal(root.get("categoryId"),
                                getAllCakeRequest.getCategoryId())
                );
            }

            if(getAllCakeRequest.getSize() != null){

                predicateList.add(
                        criteriaBuilder.equal(root.get("size"),
                                getAllCakeRequest.getSize())
                );
            }

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });
    }
}
