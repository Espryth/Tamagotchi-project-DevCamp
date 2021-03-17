package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.exception.ArgumentParseException;
import com.maimai.tamagotchi.command.exception.NoMoreArgumentsException;

public interface ArgumentStack {

    boolean hasNext();

    String next() throws NoMoreArgumentsException;

    int nextInt() throws ArgumentParseException;

    double nextDouble() throws ArgumentParseException;
}
