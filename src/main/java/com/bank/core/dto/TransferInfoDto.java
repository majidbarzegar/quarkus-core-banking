package com.bank.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransferInfoDto {
    private String from;
    private String to;
    private Long amount;
    private String trackingNumber;
    private LocalDateTime time;
}
