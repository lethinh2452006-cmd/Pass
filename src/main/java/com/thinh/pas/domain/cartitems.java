package com.thinh.pas.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cartitems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cartitems {
    @Id
    @Column(name = "id",nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        cartitems cartitems = (cartitems) o;
        return Objects.equals(id, cartitems.id) && Objects.equals(cart_id, cartitems.cart_id) && Objects.equals(quantity, cartitems.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cart_id, quantity);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private cart cart_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cakesize_id")
    private cakesize cakesize_id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
