package com.maimai.tamagotchi.command.part.defaults;

import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.command.part.ArgumentPart;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.player.Player;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ItemPart implements ArgumentPart<Item> {

    private final Player player;

    public ItemPart(Player player) {
        this.player = player;
    }

    @Override
    public Item parse(ArgumentStack argumentStack) {

        Map<String, Item> itemAliases = new HashMap<>();

        player.getInventory().getItems().forEach(item -> {

            itemAliases.put(item.getDefaultType().getName(), item);
            itemAliases.put(item.getDefaultType().toString(), item);

        });

        if(argumentStack.hasNext()) {

            String argument = argumentStack.next();

            return itemAliases.get(argument);

        }
        return null;
    }

    @Override
    public Type getType() {
        return Item.class;
    }
}
