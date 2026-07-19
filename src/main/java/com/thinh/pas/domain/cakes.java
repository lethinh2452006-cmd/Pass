package com.thinh.pas.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cake")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cakes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "namecake", nullable = false)
    private String namecake;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        cakes cakes = (cakes) o;
        return Objects.equals(id, cakes.id) && Objects.equals(namecake, cakes.namecake) && Objects.equals(description, cakes.description) && Objects.equals(image, cakes.image) && Objects.equals(createdAt, cakes.createdAt) && Objects.equals(updatedAt, cakes.updatedAt) && Objects.equals(deletedAt, cakes.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namecake, description, image, createdAt, updatedAt, deletedAt);
    }

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "created_at",updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deletedat",updatable = false)
    private LocalDateTime deletedAt;

}
