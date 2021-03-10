package com.maimai.tamagotchi;

import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.event.SimpleEventRegister;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.food.FoodItem;

public class Main {

    public static void main(String... args) {

        Item test = new FoodItem.Builder()
                .build();

        EventRegister eventRegister = new SimpleEventRegister();

        eventRegister.registerEvents(
                new TestListener()
        );

        eventRegister.callEvent(new TestEvent("ASDASDASD"));
    }

}
