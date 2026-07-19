package com.thinh.pas.respositories;

import com.thinh.pas.domain.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<users, UUID> {

}
