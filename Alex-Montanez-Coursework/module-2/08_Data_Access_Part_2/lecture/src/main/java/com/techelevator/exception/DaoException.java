package com.techelevator.exception;

public class DaoException extends RuntimeException {
    public static final String NO_DATABASE_ERROR = "Unable to connect to server or database";
    public static final String DATA_INTEGRITY_ERROR = "Error";

    public DaoException() {
        super();
    }
    public DaoException(String message) {
        super(message);
    }
    public DaoException(String message, Exception cause) {
        super(message, cause);
    }
}
