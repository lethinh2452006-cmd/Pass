package com.thinh.pas.repositories;

import com.thinh.pas.domain.entities.cakes;
import com.thinh.pas.domain.reponse.GetCakeReponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface CakeRepository extends JpaRepository<cakes, UUID> {
    List<GetCakeReponse> findAll(Specification<cakes> specification, Pageable pageable);
}
