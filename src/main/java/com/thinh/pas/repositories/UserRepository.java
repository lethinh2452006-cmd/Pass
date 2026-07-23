package com.thinh.pas.repositories;

import com.thinh.pas.domain.entities.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<users, UUID> {
    Optional<users> findAllById(UUID userId);
}
