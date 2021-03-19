package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.action.SimpleAction;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;
import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.utils.MessageUtils;


public class CatTamagotchi extends AbstractTamagotchi{


    public CatTamagotchi(String name) {
        super(name, TamagotchiType.CAT);
    }

    @Override
    public void registerActions(ProgramCore core) {
        registerAction(core,"pet", new SimpleAction.Builder()
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
                    MessageUtils.sendMessageFromLang(core, "tamagotchi.cat.pet", player.getTamagotchi().getName());
                }).build());

        registerAction(core,"bath", new SimpleAction.Builder()
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
                    MessageUtils.sendMessageFromLang(core, "tamagotchi.cat.bath", player.getTamagotchi().getName());
                }).build());

        registerAction(core,"exercise", new SimpleAction.Builder()
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
                    player.getTamagotchi().getHunger().decrement(40D);
                    player.getTamagotchi().getThirst().decrement(40D);
                    player.getTamagotchi().getHappiness().decrement(10D);
                    player.getTamagotchi().getDirty().increase(50D);
                    player.getMoney().increase(15);
                    MessageUtils.sendMessageFromLang(core, "tamagotchi.cat.exercise", player.getTamagotchi().getName());
                }).build());

    }
}
