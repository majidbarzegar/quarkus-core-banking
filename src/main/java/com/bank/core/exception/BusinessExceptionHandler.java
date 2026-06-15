package com.bank.core.exception;

import com.bank.core.dto.ResponseDto;
import com.bank.core.util.MessageUtil;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException ex) {
        return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .entity(
                        new ResponseDto<>(
                                MessageUtil.getMessage(ex.getMessageKey(), ex.getArgs()),
                                ex.getCode()
                        )
                )
                .build();
    }
}