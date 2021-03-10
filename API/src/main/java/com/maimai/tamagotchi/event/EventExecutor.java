package com.maimai.tamagotchi.event;

@FunctionalInterface
public interface EventExecutor {
    void execute(Listener listener, Event event);
}
