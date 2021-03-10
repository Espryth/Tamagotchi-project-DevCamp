package com.maimai.tamagotchi;

import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.event.SimpleEventRegister;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.food.FoodItem;
import com.maimai.tamagotchi.item.food.FoodType;

public class Main {

    public static void main(String... args) {

        Item teest = new FoodItem.Builder()
                .createItemHandler((t,p) -> {

                })
                .setType(FoodType.APPLE)
                .build();

        System.out.println(teest.getDefaultType().getValue());
    }

}
