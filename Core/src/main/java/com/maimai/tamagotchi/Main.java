package com.maimai.tamagotchi;

import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.event.SimpleEventRegister;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.food.FoodItem;
import com.maimai.tamagotchi.item.food.FoodType;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.module.Module;

public class Main {

    private static EventRegister eventRegister;

    public static void main(String... args) {
        Module module = new MainModule();
        module.start();
        eventRegister = new SimpleEventRegister();


        Item teest = new FoodItem.Builder()
                .createExecutor((t,p) -> {

                })
                .setType(FoodType.APPLE)
                .build();

        System.out.println(teest.getDefaultType().getValue());
    }

    public static EventRegister getEventRegister() {
        return eventRegister;
    }
}
