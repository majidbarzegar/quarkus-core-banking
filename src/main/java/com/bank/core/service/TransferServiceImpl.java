package com.bank.core.service;

import com.bank.core.dto.TransferInfoDto;
import com.bank.core.dto.TransferRequest;
import com.bank.core.dto.TransferResponse;
import com.bank.core.entity.Customer;
import com.bank.core.entity.Transfer;
import com.bank.core.exception.BusinessException;
import com.bank.core.exception.Message;
import com.bank.core.mapper.TransferInfoMapper;
import com.bank.core.repository.TransferRepository;
import com.bank.core.util.RandomUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class TransferServiceImpl implements TransferService {

    @Inject
    CustomerService customerService;
    @Inject
    TransferRepository transferRepository;
    @Inject
    TransferInfoMapper transferInfoMapper;

    @Override
    @Transactional
    public TransferResponse transfer(TransferRequest request, String currentUserNationalCode) {
        if(request.amount() < 1){
            throw new BusinessException(Message.INVALID_TRANSFER_AMOUNT);
        }

        Customer sourceCustomer = customerService.findByNationalCode(currentUserNationalCode);
        if (sourceCustomer.getBalance() < request.amount()) {
            throw new BusinessException(Message.INSUFFICIENT_BALANCE);
        }
        Customer destinationCustomer = customerService.findByAccountNumber(request.destinationAccountNumber());

        sourceCustomer.setBalance(sourceCustomer.getBalance() - request.amount());
        destinationCustomer.setBalance(destinationCustomer.getBalance() + request.amount());

        Transfer transfer = new Transfer();
        transfer.setSourceCustomer(sourceCustomer);
        transfer.setDestinationCustomer(destinationCustomer);
        transfer.setAmount(request.amount());
        transfer.setTrackingNumber(RandomUtils.generate13DigitNumber());
        transferRepository.persist(transfer);

        return new TransferResponse(transfer.getTrackingNumber());
    }

    @Override
    @Transactional
    public List<TransferInfoDto> history(String nationalCode) {
        Customer sourceCustomer = customerService.findByNationalCode(nationalCode);
        List<Transfer> transfers = transferRepository.findByCustomer(sourceCustomer.getId());
        if(transfers == null || transfers.isEmpty()){
            throw new BusinessException(Message.EMPTY_HISTORY);
        }
        return transferInfoMapper.toDto(transfers);
    }
}
