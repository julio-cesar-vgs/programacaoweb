package com.example.programacaoweb.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5620042081368489934L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}