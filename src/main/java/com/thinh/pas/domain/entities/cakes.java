package com.thinh.pas.domain.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;
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
        return Objects.equals(id, cakes.id) && Objects.equals(namecake, cakes.namecake)&&  Objects.equals(description, cakes.description) && Objects.equals(image, cakes.image) &&Objects.equals(promotion, cakes.promotion) && Objects.equals(createdAt, cakes.createdAt) && Objects.equals(updatedAt, cakes.updatedAt) && Objects.equals(deleted, cakes.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namecake, description, image, promotion, createdAt, updatedAt, deleted);
    }

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @CreatedDate
    @Column(name = "created_at",updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deletedat")
    private boolean deleted;

    @Column(name = "category_id")
    private UUID categoryId;

    @OneToMany(mappedBy = "cake_id", fetch = FetchType.LAZY)
    private List<cakesize> cakeSizes;

    @Column(name = "promotion")
    private Integer promotion;

    public void update(String namecake,String description, String image){
        this.namecake = namecake;
        this.description = description;
        this.image = image;
    }

    public void deleted(boolean deleted){
        this.deleted = deleted;
    }
}
