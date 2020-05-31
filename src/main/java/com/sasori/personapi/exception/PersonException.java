package com.sasori.personapi.exception;

import lombok.Getter;

@Getter
public class PersonException extends RuntimeException {

    private final String code;

    public PersonException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}
