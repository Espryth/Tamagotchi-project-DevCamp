package com.maimai.tamagotchi.command.part.defaults;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.command.exception.ArgumentParseException;
import com.maimai.tamagotchi.command.part.ArgumentPart;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.player.Player;

import java.lang.reflect.Type;

public class ActionPart implements ArgumentPart<Action<Player>> {

    private final Manager<String, Action<Player>> actionManager;

    public ActionPart(Manager<String, Action<Player>> actionManager) {
        this.actionManager = actionManager;
    }

    @Override
    public Action<Player> parse(ArgumentStack argumentStack) {

        if(argumentStack.hasNext()) {
            if(!actionManager.find(argumentStack.next()).isPresent()) {
                throw new ArgumentParseException("No se pudo pa");
            }
            return actionManager.find(argumentStack.next()).get();
        }

        return null;
    }

    @Override
    public Type getType() {
        return Action.class;
    }
}
