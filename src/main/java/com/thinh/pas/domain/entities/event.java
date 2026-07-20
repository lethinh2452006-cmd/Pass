package com.thinh.pas.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "organizationat", nullable = false)
    private String organizationAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        event event = (event) o;
        return Objects.equals(id, event.id) && Objects.equals(organizationAt, event.organizationAt) && Objects.equals(description, event.description) && Objects.equals(capacity, event.capacity) && Objects.equals(timestart, event.timestart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organizationAt, description, capacity, timestart);
    }

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "timestart", nullable = false)
    private LocalDateTime timestart;

    @Column(name = "eventstatus", nullable = false)
    private eventstatus status;
}
