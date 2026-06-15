package com.bank.core.resource;

import com.bank.core.dto.CustomerDto;
import com.bank.core.dto.ResponseDto;
import com.bank.core.entity.Customer;
import com.bank.core.mapper.CustomerMapper;
import com.bank.core.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api/bank/core/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerRecourse {

    @Inject
    CustomerService customerService;
    @Inject
    CustomerMapper customerMapper;

    @POST
    public ResponseDto<CustomerDto> save(Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return new ResponseDto<>(
                customerMapper.toDto(savedCustomer)
        );
    }

    @DELETE
    @Path("/{id}")
    public ResponseDto<String> delete(@PathParam("id") Long id) {
        customerService.delete(id);
        return new ResponseDto<>("CUSTOMER_DELETE_SUCCESSFULLY");
    }

    @GET
    @Path("/{id}")
    public ResponseDto<CustomerDto> findById(@PathParam("id") Long id) {
        Customer customer = customerService.findById(id);
        return new ResponseDto<>(
                customerMapper.toDto(customer)
        );
    }
}
