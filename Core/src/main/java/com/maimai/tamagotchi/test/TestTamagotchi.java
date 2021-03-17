package com.maimai.tamagotchi.test;

import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.tamagotchi.action.TamagotchiAction;

public class TestTamagotchi extends AbstractTamagotchi {
    public TestTamagotchi(String id, String name, TamagotchiType type) {
        super(name, type);
    }

    @Override
    public void registerActions() {
        registerAction("comer", new TamagotchiAction.Builder()
                .createRequirement(player -> {
                    return true;
                })
                .createExecutor(player -> {

                })
                .build());
    }
}
