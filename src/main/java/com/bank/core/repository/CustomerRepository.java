package com.bank.core.repository;

import com.bank.core.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public boolean isExist(Long id) {
        if (id == null) {
            return false;
        }
        return count("id", id) > 0;
    }
}
