package com.lukaklacar.oop.util;

public class CannotWriteToFileException extends RuntimeException {
    public CannotWriteToFileException(Throwable cause) {
        super(cause);
    }
}
