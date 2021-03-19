package com.maimai.tamagotchi.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.item.AbstractItem;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.player.Player;
import com.maimai.tamagotchi.player.SimplePlayer;
import com.maimai.tamagotchi.player.inventory.PlayerInventory;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.statistic.impl.DoubleStatistic;
import com.maimai.tamagotchi.tamagotchi.SimpleTamagotchi;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class InterfaceDeserializer {

    public static SimpleModule getAbstractTypes() {

        SimpleModule module = new SimpleModule("InterfaceDeserializer", Version.unknownVersion());

        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver()
                .addMapping(Tamagotchi.class, SimpleTamagotchi.class)
                .addMapping(Player.class, SimplePlayer.class)
                .addMapping(Statistic.class, DoubleStatistic.class)
                .addMapping(Inventory.class, PlayerInventory.class)
                .addMapping(Item.class, AbstractItem.class);

        module.setAbstractTypes(resolver);

        return module;
    }
}
