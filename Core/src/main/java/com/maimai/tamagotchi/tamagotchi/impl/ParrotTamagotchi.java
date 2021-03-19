package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.action.SimpleAction;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;
import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.utils.MessageUtils;

public class ParrotTamagotchi extends AbstractTamagotchi {
    private final ProgramCore core;
    public ParrotTamagotchi(ProgramCore core, String name) {
        super(core, name, TamagotchiType.PARROT);
        this.core = core;
    }

    @Override
    public void registerActions() {
        registerAction("Pet", new SimpleAction.Builder()
                .createRequirement((player, item) -> {
                    if(item == null) {
                        return true;
                    }
                    MessageUtils.sendMessageFromLang(core, "actions.notRequiresItem");
                    return false;
                })
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().increase(40D);
                    player.getMoney().increase(5);
                    MessageUtils.sendMessageFromLang(core, "tamagotchi.parrot.pet", player.getTamagotchi().getName());
                }).build());

        registerAction("Bath", new SimpleAction.Builder()
                .createRequirement((player, item) -> {
                    if(item == null) {
                        return true;
                    }
                    MessageUtils.sendMessageFromLang(core, "actions.notRequiresItem");
                    return false;
                })
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().decrement(20D);
                    player.getTamagotchi().getDirty().decrement(80D);
                    player.getMoney().increase(10);
                    MessageUtils.sendMessageFromLang(core, "tamagotchi.parrot.bath", player.getTamagotchi().getName());
                }).build());

        registerAction("Exercise", new SimpleAction.Builder()
                .createRequirement((player, item) -> {
                    if(item == null) {
                        if (!(player.getTamagotchi().getFatigue().getValue() <= 40)){
                            return true;
                        } else {
                            MessageUtils.sendMessageFromLang(core, "tamagotchi.canNotDoExercise", player.getTamagotchi().getName());
                            return false;
                        }
                    }
                    MessageUtils.sendMessageFromLang(core, "actions.notRequiresItem");
                    return false;
                })
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getFatigue().decrement(40D);
                    player.getTamagotchi().getHunger().decrement(50D);
                    player.getTamagotchi().getThirst().decrement(40D);
                    player.getTamagotchi().getHappiness().increase(20D);
                    player.getTamagotchi().getDirty().increase(50D);
                    player.getMoney().increase(15);
                    MessageUtils.sendMessageFromLang(core, "tamagotchi.parrot.exercise", player.getTamagotchi().getName());
                }).build());


    }

}
