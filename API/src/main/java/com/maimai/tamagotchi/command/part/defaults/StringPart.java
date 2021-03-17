package com.maimai.tamagotchi.command.part.defaults;

import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.command.part.ArgumentPart;

import java.lang.reflect.Type;

public class StringPart implements ArgumentPart<String> {
    @Override
    public String parse(ArgumentStack argumentStack) {

        if(argumentStack.hasNext()) {
            return argumentStack.next();
        }
        return null;
    }

    @Override
    public Type getType() {
        return String.class;
    }
}
