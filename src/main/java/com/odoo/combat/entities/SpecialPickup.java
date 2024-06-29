package com.odoo.combat.entities;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.odoo.combat.entities.constants.PickupStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecialPickup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pickupId;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    private PickupStatus status;

    @CreationTimestamp
    private LocalDateTime requestedAt;
    
    private LocalDateTime scheduledAt;
    
    @UpdateTimestamp
    private LocalDateTime completedAt;

    @OneToOne
    private Address address;
}

