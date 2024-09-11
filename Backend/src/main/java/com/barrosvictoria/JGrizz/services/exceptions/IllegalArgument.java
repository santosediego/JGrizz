package com.barrosvictoria.JGrizz.services.exceptions;

public class IllegalArgument extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IllegalArgument(String msg) {
        super(msg);
    }
}
