package com.maimai.tamagotchi;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.ActionManager;
import com.maimai.tamagotchi.action.tamagotchi.TamagotchiAction;

import com.maimai.tamagotchi.tamagotchi.SimpleTamagotchi;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class Main {

    public static void main(String... args) {

        Tamagotchi tamagotchi = new SimpleTamagotchi();

        tamagotchi.getActions().add(new TamagotchiAction.Builder()
                .setName("test")
                .createActionHandler(t -> {
                    System.out.println("test");
                    System.out.println("test2");
                })
                .build());

        tamagotchi.getActions().forEach(action -> action.getActionHandler().execute(tamagotchi));
    }
}
