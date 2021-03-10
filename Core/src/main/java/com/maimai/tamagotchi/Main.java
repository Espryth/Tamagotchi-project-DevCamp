package com.maimai.tamagotchi;

import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.event.SimpleEventRegister;
import com.maimai.tamagotchi.test.TestEvent;
import com.maimai.tamagotchi.test.TestListener;

public class Main {

    public static void main(String... args) {

        EventRegister eventRegister = new SimpleEventRegister();

        eventRegister.registerEvents(
                new TestListener()
        );

        eventRegister.callEvent(new TestEvent("ASDASDASD"));
    }

}
