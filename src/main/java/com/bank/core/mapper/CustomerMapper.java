package com.bank.core.mapper;

import com.bank.core.dto.CustomerDto;
import com.bank.core.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {
    Customer toEntity(CustomerDto dto);

    List<Customer> toEntity(List<CustomerDto> dtos);

    CustomerDto toDto(Customer customer);

    List<CustomerDto> toDto(List<Customer> customers);
}
