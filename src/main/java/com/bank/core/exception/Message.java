package com.bank.core.exception;

public enum Message implements ExceptionMessage {
    DEFAULT_EXCEPTION(1001),
    CUSTOMER_NOT_FOUND(1002),
    ACCOUNT_NUMBER_NOT_FOUND(1003),
    EMPTY_HISTORY(1004),
    INSUFFICIENT_BALANCE(1005),
    INVALID_TRANSFER_AMOUNT(1006),
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
