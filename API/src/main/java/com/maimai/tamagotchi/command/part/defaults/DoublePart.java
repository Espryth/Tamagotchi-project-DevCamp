package com.maimai.tamagotchi.command.part.defaults;

import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.command.part.ArgumentPart;

import java.lang.reflect.Type;

public class DoublePart implements ArgumentPart<Double> {
    @Override
    public Double parse(ArgumentStack argumentStack) {

        if(argumentStack.hasNext()) {
            return argumentStack.nextDouble();
        }

        return null;
    }

    @Override
    public Type getType() {
        return Double.class;
    }
}
