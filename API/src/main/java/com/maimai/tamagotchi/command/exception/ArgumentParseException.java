package com.maimai.tamagotchi.command.exception;

public class ArgumentParseException extends RuntimeException {

    public ArgumentParseException(String message) {
        super("Failed on parse the message " + message);
    }
}
