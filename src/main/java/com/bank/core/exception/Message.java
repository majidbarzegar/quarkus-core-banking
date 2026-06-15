package com.bank.core.exception;

public enum Message implements ExceptionMessage {
    DEFAULT_EXCEPTION(1001),
    CUSTOMER_NOT_FOUND(1002),
    EMPTY_HISTORY(1003),
    ;

    private final Integer code;

    Message(Integer code) {
        this.code = code;
    }

    public String getMessageKey() {
        return this.name();
    }

    public Integer getCode() {
        return code;
    }
}
