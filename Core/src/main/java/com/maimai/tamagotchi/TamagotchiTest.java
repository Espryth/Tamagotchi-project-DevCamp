package com.maimai.tamagotchi;

import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.tamagotchi.action.TamagotchiAction;

public class TamagotchiTest extends AbstractTamagotchi {
    public TamagotchiTest(String id, String name) {
        super(id, name, TamagotchiType.CAT);
    }

    @Override
    public void registerActions() {

        registerAction("Nombre para identificar", new TamagotchiAction.Builder()
                .createActionHandler(t -> {
                    System.out.println("Aqui puedes colocar cualquier cosa");
                    t.getHunger().increase(10D);
                })
                .build());

    }
}
