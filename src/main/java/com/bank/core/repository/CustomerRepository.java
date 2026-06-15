package com.bank.core.repository;

import com.bank.core.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    @Transactional
    public boolean isExist(Long id) {
        if (id == null) {
            return false;
        }
        return count("id", id) > 0;
    }

    @Transactional
    public Optional<Customer> findByNationalCode(String nationalCode) {
        return find("nationalCode", nationalCode).firstResultOptional();
    }

    @Transactional
    public Optional<Customer> findByAccountNumber(String accountNumber) {
        return find("accountNumber", accountNumber).firstResultOptional();
    }

}
