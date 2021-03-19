package com.maimai.tamagotchi.shop;

import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.shop.action.ShopAction;

import java.util.List;

public interface Shop {

    ShopAction getShopAction();

    List<DefaultType> getDefaultType();
}