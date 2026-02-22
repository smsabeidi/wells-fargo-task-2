package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="Portfolio")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Portfolio {
    @Id
    @GeneratedValue
    private UUID portfolio_id;

    @Column(nullable = false)
    private LocalDateTime date_created;

    @Column(nullable = false)
    private LocalDateTime date_updated;

    @PrePersist
    public void prePersist(){
        date_created = LocalDateTime.now();
        date_updated = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        date_updated = LocalDateTime.now();
    }
}
