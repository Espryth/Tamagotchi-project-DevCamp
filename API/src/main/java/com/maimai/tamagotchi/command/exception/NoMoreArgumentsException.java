package com.maimai.tamagotchi.command.exception;

public class NoMoreArgumentsException extends RuntimeException {

    public NoMoreArgumentsException() {
        super("This command have not more arguments!");
    }

}
