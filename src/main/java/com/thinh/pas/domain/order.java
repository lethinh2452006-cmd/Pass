package com.thinh.pas.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "receiverphone", nullable = false)
    private String receiverphone;

    @Column(name = "shippingaddress", nullable = false)
    private String shippingaddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private users users_id;

    // private
    @Column(name = "totalamount", nullable = false)
    private Integer totalamount;

    @Column(name = "created_at",updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        order order = (order) o;
        return Objects.equals(id, order.id) && Objects.equals(receiverphone, order.receiverphone) && Objects.equals(shippingaddress, order.shippingaddress) && Objects.equals(totalamount, order.totalamount) && Objects.equals(createdAt, order.createdAt) && Objects.equals(updatedAt, order.updatedAt) && Objects.equals(deletedAt, order.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, receiverphone, shippingaddress, totalamount, createdAt, updatedAt, deletedAt);
    }

    @Column(name = "deletedat",updatable = false)
    private LocalDateTime deletedAt;

}
