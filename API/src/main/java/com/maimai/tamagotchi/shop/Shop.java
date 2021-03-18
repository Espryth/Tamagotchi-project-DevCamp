package com.maimai.tamagotchi.shop;

import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.loader.Loader;
import com.maimai.tamagotchi.shop.action.ShopAction;

import java.util.List;

public interface Shop extends Loader {

    ShopAction getShopAction();

    List<DefaultType> getDefaultType();
}