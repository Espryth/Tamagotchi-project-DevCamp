package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.action.SimpleAction;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;
import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;

public class DogTamagotchi extends AbstractTamagotchi {
    private final ProgramCore core;
    public DogTamagotchi(ProgramCore core, String name) {
        super(core, name, TamagotchiType.DOG);
        this.core = core;
    }

    @Override
    public void registerActions() {
        registerAction("Pet", new SimpleAction.Builder()
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().increase(40D);
                    player.getMoney().increase(5);
                    System.out.println(player.getTamagotchi().getName()+" is very excited and is licking you");
                }).build());

        registerAction("Bath", new SimpleAction.Builder()
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().increase(40D);
                    player.getTamagotchi().getDirty().decrement(80D);
                    player.getMoney().increase(10);
                    System.out.println(player.getTamagotchi().getName()+" is very happy");
                }).build());

        registerAction("Exercise", new SimpleAction.Builder()
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHunger().decrement(40D);
                    player.getTamagotchi().getThirst().decrement(40D);
                    player.getTamagotchi().getHappiness().increase(30D);
                    player.getTamagotchi().getDirty().increase(50D);
                    player.getMoney().increase(15);
                    System.out.println(player.getTamagotchi().getName()+" is very energetic");
                }).build());

    }

}
