package com.maimai.tamagotchi.event;

public interface EventRegister {

    void callEvent(Event event);

    void registerEvents(Listener... listeners);

}
