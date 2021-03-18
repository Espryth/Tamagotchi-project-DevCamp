package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.TamagotchiCore;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.annotation.OptArg;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.ItemType;
import com.maimai.tamagotchi.item.food.FoodType;
import com.maimai.tamagotchi.item.toy.ToyType;
import com.maimai.tamagotchi.module.Module;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.shop.ShopMain;
import com.maimai.tamagotchi.shop.action.ShopAction;

import java.util.List;

public class ShopCommand implements CommandClass {

    private final ProgramCore core;

    public ShopCommand(ProgramCore core) {
        this.core = core;
    }

    @Command(name = "shop", usage = "/shop help")
    public void executeShopCommand(String arg, @OptArg String type, @OptArg String item) {

        Player player = core.getPlayer();
        Inventory inventory = player.getInventory();
        ShopMain shopMain = core.getShop();

        if (arg.equalsIgnoreCase("help")) {
            System.out.println("Shop help 1/3");
            System.out.println("/shop foods");
            System.out.println("/shop toys");
            System.out.println(" ");
            System.out.println("/shop buy [item]");
            System.out.println("/shop sell [item]");
            return;
        }

        if (arg.equalsIgnoreCase("toys")){
            System.out.println("List of toys");
            for (ToyType toyType : shopMain.getToys()){
                System.out.println(toyType + " - " + toyType.getValue() +   " - "  + toyType.getCost() + "$");
            }
            return;
        }

        if (arg.equalsIgnoreCase("foods")){
            System.out.println("List of foods:");
            for (FoodType foodType : shopMain.getFoods()){
                System.out.println(foodType.getName() + " - " + foodType.getValue() +  " - " + foodType.getCost() + "$");
            }
            return;
        }


        ShopAction shopAction = shopMain.getActions();
        List<DefaultType> defaultTypes = shopMain.getAllItems();

        if (arg.equalsIgnoreCase("buy")){

            if (type == null){
                System.out.println("Usage - /shop buy [foods/toys/baths]");
                return;
            }


            if (type.equalsIgnoreCase("foods")){

                if (item == null){
                    System.out.println("Usage - /shop buy foods [item]");
                    return;
                }

                try{
                    FoodType.valueOf(item.toUpperCase());
                }catch (IllegalArgumentException illegalArgumentException){
                    System.out.println("Unknown item");
                    return;
                }

                shopAction.buyItem(core.getPlayer(), ItemType.FOOD, FoodType.valueOf(item.toUpperCase()));
                return;
            }

            if (type.equalsIgnoreCase("toys")){
                if (item == null){
                    System.out.println("Usage - /shop buy toys [item]");
                    return;
                }

                try{
                    FoodType.valueOf(item.toUpperCase());
                }catch (IllegalArgumentException illegalArgumentException){
                    System.out.println("Unknown item");
                    return;
                }

                shopAction.buyItem(core.getPlayer(), ItemType.TOY, ToyType.valueOf(item.toUpperCase()));
                return;
            }

            System.out.println("Unknown type");
            return;
        }

        if (arg.equalsIgnoreCase("sell")){
            if (item == null){
                System.out.println("Usage - /shop sell [item]");
                return;
            }

            for (DefaultType defaultType : defaultTypes){
                if (!defaultType.getName().equalsIgnoreCase(item)) {
                    continue;
                }


                for (int id = 0; id < inventory.getSize(); id++) {
                    if (!inventory.getItem(id).getDefaultType().getName().equals(item)){
                        continue;
                    }

                    shopAction.sellItem(player, id);
                    return;
                }

                System.out.println("Error - You don't have the item in you inventory");
                return;
            }

            System.out.println("Error - Unknown item.");
            return;
        }

        System.out.println("Unknown argument");

    }
}
