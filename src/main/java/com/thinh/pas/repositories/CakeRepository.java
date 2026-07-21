package com.thinh.pas.repositories;

import com.thinh.pas.domain.entities.cakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CakeRepository extends JpaRepository<cakes, UUID> {
}
