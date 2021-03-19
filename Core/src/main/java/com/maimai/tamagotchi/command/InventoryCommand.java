package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.utils.MessageUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InventoryCommand implements CommandClass {

    private final ProgramCore core;

    public InventoryCommand(ProgramCore core) {

        this.core = core;
    }

    @Command(
            name = "inventory",
            usage = "/inventory"
    )
    public void executeInventoryCommand(){

        Inventory inventory = core.getPlayer().getInventory();

        MessageUtils.sendMessageFromLang(core, "inventory.title", Integer.toString(inventory.getSize()));

        Set<Item> itemSet = new HashSet<>(inventory.getItems());

        for (Item item : itemSet){

            String amount = Integer.toString(Collections.frequency(inventory.getItems(), item));
            String value = Double.toString(item.getDefaultType().getValue());

            MessageUtils.sendMessageFromLang(core, "inventory.view", item.getDefaultType().getName(), amount, value);
        }
    }

}