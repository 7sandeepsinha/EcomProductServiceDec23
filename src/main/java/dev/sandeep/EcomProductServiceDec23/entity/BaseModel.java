package dev.sandeep.EcomProductServiceDec23.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @CreationTimestamp
    private Instant createdAt;  // number of seconds/nanoseconds since 1 Jan, 1970 UTC
    @UpdateTimestamp
    private Instant updatedAt; // number of seconds/nanoseconds since 1 Jan, 1970 UTC
}
