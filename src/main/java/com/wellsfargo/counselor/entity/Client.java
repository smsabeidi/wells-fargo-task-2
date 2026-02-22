package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="Client")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Client{
    @Id
    @GeneratedValue
    private UUID client_id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime date_created;

    @Column(nullable = false)
    @UpdateTimestamp
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



