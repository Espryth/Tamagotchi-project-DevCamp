package com.maimai.tamagotchi.shop;

import com.maimai.tamagotchi.item.bath.BathType;
import com.maimai.tamagotchi.item.food.FoodType;
import com.maimai.tamagotchi.item.toy.ToyType;
import com.maimai.tamagotchi.shop.action.ShopAction;

import java.awt.event.ActionListener;

public class ShopMain {

    private final ShopAction shopAction;

    public ShopMain(){
        shopAction = new ShopAction();
    }

    public ShopAction getActions(){
        return shopAction;
    }

    public FoodType[] getFoods() {
        return FoodType.values();
    }

    public BathType[] getBaths() {
        return BathType.values();
    }

    public ToyType[] getToys() {
        return ToyType.values();
    }
}
