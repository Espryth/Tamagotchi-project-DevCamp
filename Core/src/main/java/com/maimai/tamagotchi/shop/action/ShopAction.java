package com.maimai.tamagotchi.shop.action;

import com.maimai.tamagotchi.item.*;
import com.maimai.tamagotchi.item.food.FoodItem;
import com.maimai.tamagotchi.item.food.FoodType;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.statistic.Statistic;

import javax.swing.table.DefaultTableModel;

public class ShopAction {

    public void buyItem(Player player, ItemType itemType, DefaultType defaultType){

        Statistic<Integer> money = player.getMoney();

        if (money.getValue() < defaultType.getCost()){
            System.out.println("You don't have that money.");
            return;
        }

        Item item = new ItemBuilder.Builder()
                .createExecutor((t,p) -> {
                })
                .setType(defaultType)
                .setItemType(itemType).build();

        player.getInventory().addItem(item);
        money.decrement(defaultType.getCost());

        System.out.println("You successfully sold the item, it costs " + defaultType.getCost() + "$.");
    }

    public void sellItem(Player player, int id){

        DefaultType defaultType = player.getInventory().getItem(id).getDefaultType();

        player.getInventory().removeItem(id);
        player.getMoney().increase(defaultType.getCost());

        System.out.println("You successfully sold the item, it costs " + defaultType.getCost() + "$.");

    }
}
