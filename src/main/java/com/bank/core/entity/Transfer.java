package com.bank.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_TRANSFER")
@Getter
@Setter
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_customer_id", nullable = false)
    private Customer sourceCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_customer_id", nullable = false)
    private Customer destinationCustomer;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(unique = true)
    private String trackingNumber;

    @PrePersist
    protected void onCreate() {
        this.time = LocalDateTime.now();
    }
}