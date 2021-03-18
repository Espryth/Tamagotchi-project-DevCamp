package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;
import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.tamagotchi.action.TamagotchiAction;

public class HamsterTamagotchi extends AbstractTamagotchi {
    private final ProgramCore core;
    public HamsterTamagotchi(ProgramCore core, String name) {
        super(name, TamagotchiType.HAMSTER);
        this.core = core;
    }

    @Override
    public void registerActions() {
        registerAction("Play", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().increase(40D);
                    player.getTamagotchi().getHunger().decrement(30D);
                    player.getTamagotchi().getThirst().decrement(30D);
                    player.getTamagotchi().getDirty().increase(30D);
                    System.out.println("");
                }).build());

        registerAction("Pet", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().increase(20D);
                    System.out.println(player.getTamagotchi().getName()+" is licking your hand");
                }).build());

        registerAction("Bath", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().decrement(20D);
                    player.getTamagotchi().getDirty().decrement(80D);
                    System.out.println(player.getTamagotchi().getName()+" didn't like the bath");
                }).build());
    }

}
