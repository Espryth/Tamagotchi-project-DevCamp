package com.maimai.tamagotchi.test;

import com.maimai.tamagotchi.event.Event;

public class TestEventTwo extends Event {

    private final String test;

    public TestEventTwo(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

}
