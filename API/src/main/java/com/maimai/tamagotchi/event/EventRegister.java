package com.maimai.tamagotchi.event;

import com.maimai.tamagotchi.event.listener.Listener;

public interface EventRegister {

    void callEvent(Event event);

    void registerEvents(Listener listener);

    void registerEvents(Listener... listeners);

}
