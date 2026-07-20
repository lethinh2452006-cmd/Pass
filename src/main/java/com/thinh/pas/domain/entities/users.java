package com.thinh.pas.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class users {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "hashpassword", nullable = false)
    private String hashPassword;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        users users = (users) o;
        return Objects.equals(id, users.id) && Objects.equals(firstname, users.firstname) && Objects.equals(lastname, users.lastname) && Objects.equals(phone, users.phone) && Objects.equals(email, users.email) && Objects.equals(hashPassword, users.hashPassword) && Objects.equals(role, users.role) && Objects.equals(createdAt, users.createdAt) && Objects.equals(updatedAt, users.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, phone, email, hashPassword, role, createdAt, updatedAt);
    }

    @Column(name= "role", nullable = false)
    private String role;

    @Column(name = "created_at",updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;
}
