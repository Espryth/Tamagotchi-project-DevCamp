package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.exception.ArgumentParseException;
import com.maimai.tamagotchi.command.exception.NoArgumentsException;

public interface ArgumentStack {

    boolean hasNext();

    String next() throws NoArgumentsException;

    int nextInt() throws ArgumentParseException;

    double nextDouble() throws ArgumentParseException;
}
