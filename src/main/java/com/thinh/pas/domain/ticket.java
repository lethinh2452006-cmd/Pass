package com.thinh.pas.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ticketprice", nullable = false)
    private Integer ticketprice;

    @Column(name = "paymentmethod", nullable = false)
    private String paymentmethod;

    @Column(name = "qr", nullable = false)
    private String qr;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ticket ticket = (ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(paymentmethod, ticket.paymentmethod) && Objects.equals(qr, ticket.qr) && Objects.equals(createdAt, ticket.createdAt) && ticketstatus == ticket.ticketstatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentmethod, qr, createdAt, ticketstatus);
    }

    @Column(name = "created_at",updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "ticketstatus")
    private ticketstatus ticketstatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private event event_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private  users user_id;
}
