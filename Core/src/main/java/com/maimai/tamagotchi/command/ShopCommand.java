package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.annotation.OptArg;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.DefaultType;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.item.ItemType;
import com.maimai.tamagotchi.item.impl.FoodType;
import com.maimai.tamagotchi.item.impl.ToyType;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.shop.Shop;
import com.maimai.tamagotchi.shop.TamagotchiShop;
import com.maimai.tamagotchi.shop.action.ShopAction;
import com.maimai.tamagotchi.shop.action.TamagotchiShopAction;
import com.maimai.tamagotchi.utils.MessageUtils;

import java.util.Arrays;
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
        Shop shop = core.getShop();
        ShopAction shopAction = shop.getShopAction();
        List<DefaultType> defaultTypes = shop.getDefaultType();
        switch (arg.toLowerCase()) {
            case "help":
                MessageUtils.sendMessageListFromLang(core, "shop.help");
                break;
            case "toys":
                System.out.println("List of toys");
                for (ToyType toyType : ToyType.values()){
                    MessageUtils.sendMessageFromLang(core, "shop.view",
                            toyType.getName(),
                            Double.toString(toyType.getValue()),
                            Integer.toString(toyType.getCost())
                    );
                }
                break;
            case "foods":
                System.out.println("List of foods:");
                for (FoodType foodType : FoodType.values()){
                    MessageUtils.sendMessageFromLang(core, "shop.view",
                            foodType.getName(),
                            Double.toString(foodType.getValue()),
                            Integer.toString(foodType.getCost())
                    );
                }
                break;
            case "buy":
                if (type == null){
                    MessageUtils.sendMessageFromLang(core, "commons.correctUsage","/shop buy [foods/toys/baths]");
                    break;
                }

                switch (type) {
                    case "foods":
                        if (item == null){
                            MessageUtils.sendMessageFromLang(core, "commons.correctUsage","/shop buy foods [item]");
                            break;
                        }

                        try{
                            FoodType.valueOf(item.toUpperCase());
                        }catch (IllegalArgumentException illegalArgumentException){
                            MessageUtils.sendMessageFromLang(core, "shop.unknownItem");
                            break;
                        }

                        shopAction.buyItem(player, ItemType.FOOD, FoodType.valueOf(item.toUpperCase()));
                        break;
                    case "toys":
                        if (item == null){
                            MessageUtils.sendMessageFromLang(core, "commons.correctUsage","/shop buy toys [item]");
                            break;
                        }

                        try{
                            ToyType.valueOf(item.toUpperCase());
                        }catch (IllegalArgumentException illegalArgumentException){
                            MessageUtils.sendMessageFromLang(core, "shop.unknownItem");
                            break;
                        }
                        shopAction.buyItem(player, ItemType.TOY, ToyType.valueOf(item.toUpperCase()));
                        break;
                }
                MessageUtils.sendMessageFromLang(core, "shop.unknownType");
                break;
            case "sell":
                if (item == null){
                    MessageUtils.sendMessageFromLang(core, "commons.correctUsage","/shop sell [item]");
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

                    MessageUtils.sendMessageFromLang(core, "shop.haveNotItem");
                    break;
                }
                MessageUtils.sendMessageFromLang(core, "shop.unknownItem");
                break;
            default:
                MessageUtils.sendMessageFromLang(core, "commons.unknownArgument");
                break;
        }
    }
}
