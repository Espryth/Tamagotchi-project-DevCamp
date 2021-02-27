package com.maimai.tamagotchi.player.inventory;

import com.maimai.tamagotchi.item.food.FoodItem;
import com.maimai.tamagotchi.item.toy.ToyItem;

import java.util.List;

public interface Inventory {
    List<FoodItem> getFoodItems();

    List<ToyItem> getToyItems();
    
    List<BathItem> getBathItems();
}
