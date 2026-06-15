package com.bank.core.repository;

import com.bank.core.entity.Transfer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TransferRepository implements PanacheRepository<Transfer> {

    @Transactional
    public List<Transfer> findByCustomer(Long customerId) {
        return find("sourceCustomer.id = ?1 OR destinationCustomer.id = ?1", customerId).list();
    }

}
