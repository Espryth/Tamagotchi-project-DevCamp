package com.maimai.tamagotchi.test;

import com.maimai.tamagotchi.event.Event;

public class TestEvent extends Event {

    private final String test;

    public TestEvent(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }
}
