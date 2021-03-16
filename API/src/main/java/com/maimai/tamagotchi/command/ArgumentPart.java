package com.maimai.tamagotchi.command;

public interface ArgumentPart<T> {

    T parse(ArgumentStack argumentStack);

}
