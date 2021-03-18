package com.maimai.tamagotchi.shop;

import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.impl.FoodType;
import com.maimai.tamagotchi.item.impl.ToyType;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.shop.action.ShopAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopLoader implements Loader {

    private final ShopAction shopAction;

    private final List<DefaultType> defaultTypes;

    public ShopLoader(){
        this.defaultTypes = new ArrayList<>();
        this.shopAction = new ShopAction();
    }

    @Override
    public void load() {
        defaultTypes.addAll(Arrays.asList(FoodType.values()));
        defaultTypes.addAll(Arrays.asList(ToyType.values()));
    }

    public ShopAction getActions(){
        return shopAction;
    }

    public FoodType[] getFoods() {
        return FoodType.values();
    }

    public ToyType[] getToys() {
        return ToyType.values();
    }

    public List<DefaultType> getAllItems(){
        return defaultTypes;
    }

}
