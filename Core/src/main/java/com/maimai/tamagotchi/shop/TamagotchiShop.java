package com.maimai.tamagotchi.shop;

import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.impl.FoodType;
import com.maimai.tamagotchi.item.impl.ToyType;
import com.maimai.tamagotchi.shop.action.ShopAction;
import com.maimai.tamagotchi.shop.action.TamagotchiShopAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TamagotchiShop implements Shop {

    private final TamagotchiShopAction shopAction;
    private final List<DefaultType> defaultTypes;

    public TamagotchiShop(){
        this.shopAction = new TamagotchiShopAction();
        this.defaultTypes = new ArrayList<>();
    }

    @Override
    public void load() {
        defaultTypes.addAll(Arrays.asList(FoodType.values()));
        defaultTypes.addAll(Arrays.asList(ToyType.values()));
    }

    @Override
    public ShopAction getShopAction() {
        return shopAction;
    }

    @Override
    public List<DefaultType> getDefaultType() {
        return defaultTypes;
    }
}
