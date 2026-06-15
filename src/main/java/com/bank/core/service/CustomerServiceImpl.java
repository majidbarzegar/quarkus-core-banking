package com.bank.core.service;

import com.bank.core.entity.Customer;
import com.bank.core.exception.BusinessException;
import com.bank.core.exception.Message;
import com.bank.core.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    @Inject
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer save(Customer customer) {
        customerRepository.persist(customer);
        return customer;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!customerRepository.isExist(id)){
            throw new BusinessException(Message.CUSTOMER_NOT_FOUND);
        }
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Customer findById(Long id) {
        Customer customer = customerRepository.findById(id);
        if(customer == null){
            throw new BusinessException(Message.CUSTOMER_NOT_FOUND);
        }
        return customer;
    }
}
