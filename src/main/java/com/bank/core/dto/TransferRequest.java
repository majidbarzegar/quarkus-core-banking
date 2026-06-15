package com.bank.core.dto;

public record TransferRequest(String destinationAccountNumber,
                              Long amount) {
}
