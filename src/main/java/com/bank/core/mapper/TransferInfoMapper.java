package com.bank.core.mapper;

import com.bank.core.dto.TransferInfoDto;
import com.bank.core.entity.Customer;
import com.bank.core.entity.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TransferInfoMapper {

    @Mapping(
            target = "from",
            source = "sourceCustomer"
    )
    @Mapping(
            target = "to",
            source = "destinationCustomer"
    )
    TransferInfoDto toDto(Transfer transfer);

    List<TransferInfoDto> toDto(List<Transfer> transfers);

    default String map(Customer customer) {
        return customer.getFirstName() + " " + customer.getLastName();
    }
}
