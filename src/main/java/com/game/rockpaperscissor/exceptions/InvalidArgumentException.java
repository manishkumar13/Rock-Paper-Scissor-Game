package com.game.rockpaperscissor.exceptions;

/**
 * Exception class to raise an Exception when the argument Invalid
 */
public class InvalidArgumentException extends RuntimeException {

    public InvalidArgumentException(String message) {
        super(message);
    }
}
