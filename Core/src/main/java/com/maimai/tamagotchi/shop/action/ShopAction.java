package com.maimai.tamagotchi.shop.action;

import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.ItemType;
import com.maimai.tamagotchi.item.food.FoodType;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.statistic.Statistic;

public class ShopAction {

    public void buyItem(DefaultType defaultType, Player player){

        if (defaultType == null){
            return;
        }

        Statistic<Integer> money = player.getMoney();

        if (money.getValue() < defaultType.getCost()){
            return;
        }
        money.decrement(defaultType.getCost());
    }

    public void sellItem(int id, DefaultType defaultType, Player player){

        if (defaultType == null){
            return;
        }

        if (player.getInventory().getItem(id) == null){
            return;
        }

        player.getInventory().removeItem(id);
        player.getMoney().increase(defaultType.getCost());

    }
}
