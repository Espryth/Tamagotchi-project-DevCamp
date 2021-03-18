package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.annotation.OptArg;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.ItemType;
import com.maimai.tamagotchi.item.impl.FoodType;
import com.maimai.tamagotchi.item.impl.ToyType;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.shop.Shop;
import com.maimai.tamagotchi.shop.TamagotchiShop;
import com.maimai.tamagotchi.shop.action.ShopAction;
import com.maimai.tamagotchi.shop.action.TamagotchiShopAction;

import java.util.Arrays;
import java.util.List;

public class ShopCommand implements CommandClass {

    private final ProgramCore core;

    private final Shop shop;

    public ShopCommand(ProgramCore core, Shop shop) {
        this.core = core;
        this.shop = shop;
    }

    @Command(name = "shop", usage = "/shop help")
    public void executeShopCommand(String arg, @OptArg String type, @OptArg String item) {

        Player player = core.getPlayer();
        Inventory inventory = player.getInventory();
        ShopAction shopAction = shop.getShopAction();
        List<DefaultType> defaultTypes = shop.getDefaultType();
        switch (arg.toLowerCase()) {
            case "help":
                Arrays.asList(
                        "Shop help 1/3",
                        "/shop foods",
                        "/shop toys",
                        "",
                        "/shop buy [item]",
                        "/shop sell [item]"
                ).forEach(System.out::println);
                break;
            case "toys":
                System.out.println("List of toys");
                for (ToyType toyType : ToyType.values()){
                    System.out.println(toyType + " - " + toyType.getValue() +   " - "  + toyType.getCost() + "$");
                }
                break;
            case "foods":
                System.out.println("List of foods:");
                for (FoodType foodType : FoodType.values()){
                    System.out.println(foodType.getName() + " - " + foodType.getValue() +  " - " + foodType.getCost() + "$");
                }
                break;
            case "buy":
                if (type == null){
                    System.out.println("Usage - /shop buy [foods/toys/baths]");
                    break;
                }

                switch (type) {
                    case "foods":
                        if (item == null){
                            System.out.println("Usage - /shop buy foods [item]");
                            break;
                        }

                        try{
                            FoodType.valueOf(item.toUpperCase());
                        }catch (IllegalArgumentException illegalArgumentException){
                            System.out.println("Unknown item");
                            break;
                        }

                        shopAction.buyItem(core.getPlayer(), ItemType.FOOD, FoodType.valueOf(item.toUpperCase()));
                        break;
                    case "toys":
                        if (item == null){
                            System.out.println("Usage - /shop buy toys [item]");
                            break;
                        }

                        try{
                            ToyType.valueOf(item.toUpperCase());
                        }catch (IllegalArgumentException illegalArgumentException){
                            System.out.println("Unknown item");
                            break;
                        }
                        shopAction.buyItem(core.getPlayer(), ItemType.TOY, ToyType.valueOf(item.toUpperCase()));
                        break;
                }
                System.out.println("Unknown type");
                break;
            case "sell":
                if (item == null){
                    System.out.println("Usage - /shop sell [item]");
                    break;
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
                        break;
                    }

                    System.out.println("Error - You don't have the item in you inventory");
                    break;
                }
                System.out.println("Error - Unknown item.");
                break;
            default:
                System.out.println("Unknown argument");
                break;
        }
    }
}
