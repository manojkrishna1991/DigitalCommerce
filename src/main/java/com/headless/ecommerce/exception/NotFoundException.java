package com.headless.ecommerce.exception;

public class NotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("not found");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
