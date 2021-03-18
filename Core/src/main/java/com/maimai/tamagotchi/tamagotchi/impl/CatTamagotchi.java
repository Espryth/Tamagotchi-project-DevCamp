package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.action.SimpleAction;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;
import com.maimai.tamagotchi.item.impl.ToyType;
import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;


public class CatTamagotchi extends AbstractTamagotchi{
    private final ProgramCore core;
    public CatTamagotchi(ProgramCore core, String name) {
        super(core, name, TamagotchiType.CAT);
        this.core = core;
    }

    @Override
    public void registerActions() {
        registerAction("Pet", new SimpleAction.Builder()
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().increase(40D);
                    player.getMoney().increase(5);
                    System.out.println(player.getTamagotchi().getName()+" is purring");
                }).build());

        registerAction("Bath", new SimpleAction.Builder()
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().decrement(20D);
                    player.getTamagotchi().getDirty().decrement(80D);
                    player.getMoney().increase(10);
                    System.out.println(player.getTamagotchi().getName()+" is upset with you");
                }).build());

        registerAction("Exercise", new SimpleAction.Builder()
                .createRequirement((player, item) -> {
                    if (!(player.getTamagotchi().getFatigue().getValue() <= 40)){
                        return true;
                    }else {
                        System.out.println(player.getTamagotchi().getName() + " is very tired to exercise");
                        return false;
                    }
                })
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getFatigue().decrement(40D);
                    player.getTamagotchi().getHunger().decrement(40D);
                    player.getTamagotchi().getThirst().decrement(40D);
                    player.getTamagotchi().getHappiness().decrement(10D);
                    player.getTamagotchi().getDirty().increase(50D);
                    player.getMoney().increase(15);
                    System.out.println(player.getTamagotchi().getName()+" is irritated");
                }).build());

    }
}
