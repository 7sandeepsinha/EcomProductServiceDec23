package dev.sandeep.EcomProductServiceDec23.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @CreationTimestamp
    private Instant createdAt;  // number of milliseconds since 1 Jan, 1970 UTC
    @UpdateTimestamp
    private Instant updatedAt; // number of milliseconds since 1 Jan, 1970 UTC
}
