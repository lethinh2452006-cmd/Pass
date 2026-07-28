package com.thinh.pas.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cakesize")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cakesize {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        cakesize cakesize = (cakesize) o;
        return Objects.equals(id, cakesize.id) && Objects.equals(price, cakesize.price) && Objects.equals(stock, cakesize.stock) && Objects.equals(size_id, cakesize.size_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price,  stock, size_id);
    }

    @Column(name = "price", nullable = false)
    private Integer price;


    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cake_id")
    private cakes cake_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private size size_id;
}
