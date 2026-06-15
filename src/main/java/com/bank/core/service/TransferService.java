package com.bank.core.service;

import com.bank.core.dto.TransferInfoDto;
import com.bank.core.dto.TransferRequest;
import com.bank.core.dto.TransferResponse;

import java.util.List;

public interface TransferService {
    TransferResponse transfer(TransferRequest request, String currentUserNationalCode);

    List<TransferInfoDto> history(String nationalCode);
}
