package com.thinh.pas.repositories;

import com.thinh.pas.domain.entities.category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<category, UUID> {
    List<category> findAll();
}