package com.nam.migi_service.exception;

public enum ErrorCode {
    USERNAME_INVALID(1001, "Username is invalid"),
    UNCCATEGORIZED_EXCEPTION(1002, "Uncategorized Exception"),
    USER_EXISTED(1003, "User already existed"),
    INVALID_PASSWORD(1004, "Password must be at least 8 character"),
    INVALID_KEY(1005, "Invalid message key"),
    USER_NOT_EXISTED(1006, "User not existed");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
