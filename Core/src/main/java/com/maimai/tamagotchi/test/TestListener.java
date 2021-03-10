package com.maimai.tamagotchi.test;

import com.maimai.tamagotchi.event.EventHandler;
import com.maimai.tamagotchi.event.Listener;

public class TestListener implements Listener {

    @EventHandler
    public void test(TestEvent event) {
        System.out.println(event.getTest());
    }
}
