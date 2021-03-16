package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.exception.ArgumentParseException;
import com.maimai.tamagotchi.command.exception.NoArgumentsException;

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
            throw new NoArgumentsException("No hay mas argumentos");
        }

        return arguments.get(index++);
    }

    @Override
    public int nextInt() {

        String next = next();

        try {
            return Integer.parseInt(next);
        } catch (NumberFormatException e) {
            throw new ArgumentParseException("Failed to parse the string " + next + " as int!");
        }
    }

    @Override
    public double nextDouble() {

        String next = next();

        try {
            return Double.parseDouble(next);
        } catch (NumberFormatException e) {
            throw new ArgumentParseException("Failed to parse the string " + next + " as double!");
        }
    }
}
