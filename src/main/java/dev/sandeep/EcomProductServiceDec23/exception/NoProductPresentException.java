package dev.sandeep.EcomProductServiceDec23.exception;

public class NoProductPresentException extends RuntimeException{

    public NoProductPresentException(String message) {
        super(message);
    }
}
