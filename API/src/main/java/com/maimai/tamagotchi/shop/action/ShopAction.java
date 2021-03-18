package com.maimai.tamagotchi.shop.action;

import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.ItemType;
import com.maimai.tamagotchi.player.Player;

public interface ShopAction {

    void buyItem(Player player, ItemType itemType, DefaultType defaultType);

    void sellItem(Player player, int id);

}