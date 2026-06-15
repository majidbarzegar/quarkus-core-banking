package com.bank.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_CUSTOMER")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private Long balance;
}
