package com.maimai.tamagotchi.event;

import com.maimai.tamagotchi.event.exception.EventException;

public interface EventRegister {

    void callEvent(Event event) throws EventException;

    void registerEvents(Listener... listeners);

}
