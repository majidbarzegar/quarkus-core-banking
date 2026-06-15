package com.bank.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private Long balance;
}
