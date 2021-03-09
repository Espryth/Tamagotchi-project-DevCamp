package com.maimai.tamagotchi.tamagotchi;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.tamagotchi.TamagotchiAction;

public class Test extends AbstractTamagotchi {


    @Override
    public final void registerActions() {

        registerAction("test", new TamagotchiAction.Builder()
                .createActionHandler(t -> {
                    System.out.println("test");
                    System.out.println("test2");
                })
                .build());


    }
}
