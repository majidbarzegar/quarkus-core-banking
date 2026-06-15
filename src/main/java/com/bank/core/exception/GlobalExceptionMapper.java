package com.bank.core.exception;

import com.bank.core.dto.ResponseDto;
import com.bank.core.util.MessageUtil;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .entity(
                        new ResponseDto<>(
                                MessageUtil.getMessage(Message.DEFAULT_EXCEPTION.getMessageKey()),
                                Message.DEFAULT_EXCEPTION.getCode()
                        )
                )
                .build();
    }
}