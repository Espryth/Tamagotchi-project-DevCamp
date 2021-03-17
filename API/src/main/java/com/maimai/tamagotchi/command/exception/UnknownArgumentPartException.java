package com.maimai.tamagotchi.command.exception;

public class UnknownArgumentPartException extends RuntimeException {

    public UnknownArgumentPartException() {
        super("Unknown argument part!");
    }
}
