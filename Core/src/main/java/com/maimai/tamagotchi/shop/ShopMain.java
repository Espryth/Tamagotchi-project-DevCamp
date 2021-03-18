package com.maimai.tamagotchi.shop;

import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.bath.BathType;
import com.maimai.tamagotchi.item.food.FoodType;
import com.maimai.tamagotchi.item.toy.ToyType;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.shop.action.ShopAction;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopMain {

    private final ShopAction shopAction;

    private List<DefaultType> defaultTypes = new ArrayList<>();

    public ShopMain(){
        shopAction = new ShopAction();
        load();
    }

    public void load() {
        defaultTypes.addAll(Arrays.asList(FoodType.values()));
        defaultTypes.addAll(Arrays.asList(BathType.values()));
        defaultTypes.addAll(Arrays.asList(ToyType.values()));
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

    public List<DefaultType> getAllItems(){
        return defaultTypes;
    }

}
