package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.exception.ArgumentParseException;
import com.maimai.tamagotchi.command.exception.NoMoreArgumentsException;

import java.util.List;

public class SimpleArgumentStack implements ArgumentStack{

    protected final List<String> arguments;

    private int index = 0;

    public SimpleArgumentStack(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean hasNext() {
        return arguments.size() > index;
    }

    @Override
    public String next() {
        if(!hasNext()) {
            throw new NoMoreArgumentsException();
        }

        return arguments.get(index++);
    }

    @Override
    public int nextInt() {

        String next = next();

        try {
            return Integer.parseInt(next);
        } catch (NumberFormatException e) {
            throw new ArgumentParseException(next);
        }
    }

    @Override
    public double nextDouble() {

        String next = next();

        try {
            return Double.parseDouble(next);
        } catch (NumberFormatException e) {
            throw new ArgumentParseException(next);
        }
    }
}
