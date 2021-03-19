package com.maimai.tamagotchi.shop;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.impl.FoodType;
import com.maimai.tamagotchi.item.impl.ToyType;
import com.maimai.tamagotchi.shop.action.ShopAction;
import com.maimai.tamagotchi.shop.action.TamagotchiShopAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TamagotchiShop implements Shop {

    private final ProgramCore core;
    private final TamagotchiShopAction shopAction;
    private final List<DefaultType> defaultTypes;

    public TamagotchiShop(ProgramCore core){
        this.core = core;
        this.shopAction = new TamagotchiShopAction(core);
        this.defaultTypes = new ArrayList<>();
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
