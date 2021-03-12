package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.tamagotchi.action.TamagotchiAction;

public class CatTamagotchi extends AbstractTamagotchi {
    public CatTamagotchi(String id, String name) {
        super(id, name, TamagotchiType.CAT);
    }

    @Override
    public void registerActions() {
        registerAction("Jugar", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    player.getTamagotchi().getHappiness().increase(20D);
                    player.getTamagotchi().getHunger().decrement(10D);
                    player.getTamagotchi().getThirst().decrement(10D);
                    player.getTamagotchi().getDirty().increase(30D);
                }).build());

        registerAction("Acariciar", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    player.getTamagotchi().getHappiness().decrement(20D);
                    player.getTamagotchi().getDirty().decrement(40D);
                    System.out.println(player.getTamagotchi().getName()+" is purring");
                }).build());

        registerAction("Bañar", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    player.getTamagotchi().getHappiness().decrement(10D);
                    System.out.println(player.getTamagotchi().getName()+" is very angry");
                }).build());
    }
}
