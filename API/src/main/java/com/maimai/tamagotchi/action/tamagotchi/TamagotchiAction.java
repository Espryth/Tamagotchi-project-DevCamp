package com.maimai.tamagotchi.action.tamagotchi;

import com.maimai.tamagotchi.action.AbstractAction;
import com.maimai.tamagotchi.action.ActionHandler;
import com.maimai.tamagotchi.tamagotchi.Tamagotchi;

public class TamagotchiAction extends AbstractAction<Tamagotchi> {

    public TamagotchiAction(String name, ActionHandler<Tamagotchi> actionHandler) {
        super(name, actionHandler);
    }
}
