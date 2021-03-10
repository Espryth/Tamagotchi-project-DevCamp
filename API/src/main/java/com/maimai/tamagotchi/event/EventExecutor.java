package com.maimai.tamagotchi.event;

import com.maimai.tamagotchi.event.listener.Listener;

@FunctionalInterface
public interface EventExecutor {
    void execute(Listener listener, Event event);
}
