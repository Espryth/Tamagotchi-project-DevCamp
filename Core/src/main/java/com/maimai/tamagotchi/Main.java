package com.maimai.tamagotchi;

import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.food.FoodItem;
import com.maimai.tamagotchi.item.food.FoodType;

public class Main {

    public static void main(String... args) {

        Item apple = new FoodItem.Builder()
                .setFoodType(FoodType.APPLE)
                .createItemHandler((tamagotchi, player) -> {

                })
                .build();

    }
}
