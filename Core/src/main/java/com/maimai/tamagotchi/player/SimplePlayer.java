package com.maimai.tamagotchi.player;

import com.maimai.tamagotchi.inventory.Inventory;
import com.maimai.tamagotchi.player.inventory.PlayerInventory;
import com.maimai.tamagotchi.player.language.Language;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.statistic.impl.IntegerStatistic;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

import java.beans.ConstructorProperties;
import java.util.UUID;

public class SimplePlayer implements Player {

    private final String id;
    private final String name;

    private final Tamagotchi tamagotchi;
    private final Inventory inventory;
    private final Statistic<Integer> money;

    private final Language language;

    @ConstructorProperties({
            "name",
            "tamagotchi",
            "language"
    })
    public SimplePlayer(String name,
                        Tamagotchi tamagotchi,
                        Language language) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.language = language;
        this.tamagotchi = tamagotchi;
        this.inventory = new PlayerInventory();
        this.money = new IntegerStatistic();
    }

    @Override
    public Tamagotchi getTamagotchi() {
        return tamagotchi;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public Statistic<Integer> getMoney() {
        return money;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}
