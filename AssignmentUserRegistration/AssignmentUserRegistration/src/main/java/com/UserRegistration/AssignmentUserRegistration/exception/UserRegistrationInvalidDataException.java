package com.UserRegistration.AssignmentUserRegistration.exception;

public class UserRegistrationInvalidDataException extends RuntimeException{
    public UserRegistrationInvalidDataException() {
    }

    public UserRegistrationInvalidDataException(String message) {
        super(message);
    }

    public UserRegistrationInvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
