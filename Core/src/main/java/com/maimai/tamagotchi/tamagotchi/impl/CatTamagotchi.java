package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.tamagotchi.action.TamagotchiAction;


public class CatTamagotchi extends AbstractTamagotchi{
    private final ProgramCore core;
    public CatTamagotchi(ProgramCore core, String id, String name) {
        super(id, name, TamagotchiType.CAT);
        this.core = core;
    }

    @Override
    public void registerActions() {
        registerAction("Play", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    player.getTamagotchi().getHappiness().increase(20D);
                    player.getTamagotchi().getHunger().decrement(10D);
                    player.getTamagotchi().getThirst().decrement(10D);
                    player.getTamagotchi().getDirty().increase(30D);
                }).build());

        registerAction("Pet", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    player.getTamagotchi().getHappiness().decrement(20D);
                    player.getTamagotchi().getDirty().decrement(40D);
                    System.out.println(player.getTamagotchi().getName()+" is purring");
                }).build());

        registerAction("Bath", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    player.getTamagotchi().getHappiness().decrement(10D);
                    System.out.println(player.getTamagotchi().getName()+" is very angry");
                }).build());
    }

}
