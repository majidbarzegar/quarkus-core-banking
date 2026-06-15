package com.bank.core.service;

import com.bank.core.entity.Customer;

public interface CustomerService {
    Customer save(Customer customer);

    void delete(Long id);

    Customer findById(Long id);

    Customer findByNationalCode(String nationalCode);

    Customer findByAccountNumber(String accountNumber);
}
