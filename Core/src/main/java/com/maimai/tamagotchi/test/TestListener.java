package com.maimai.tamagotchi.test;

import com.maimai.tamagotchi.event.EventHandler;
import com.maimai.tamagotchi.event.listener.Listener;

public class TestListener implements Listener {

    @EventHandler
    public void test(TestEvent event) {
        System.out.println(event.getTest());
    }

    @EventHandler
    public void testtwo(TestEvent event) {
        System.out.println(event.getTest() + " poto");
    }

    @EventHandler
    public void te(TestEventTwo event) {
        System.out.println(event.getTest() + " pa");
    }

}
