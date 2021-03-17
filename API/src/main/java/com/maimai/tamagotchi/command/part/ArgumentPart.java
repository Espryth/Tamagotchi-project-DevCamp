package com.maimai.tamagotchi.command.part;

import com.maimai.tamagotchi.command.ArgumentStack;

import java.lang.reflect.Type;

public interface ArgumentPart<T> {

    T parse(ArgumentStack argumentStack);

    Type getType();
}
