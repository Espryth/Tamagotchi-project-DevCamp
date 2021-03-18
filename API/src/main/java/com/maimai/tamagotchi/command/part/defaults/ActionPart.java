package com.maimai.tamagotchi.command.part.defaults;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.command.part.ArgumentPart;
import com.maimai.tamagotchi.manager.Manager;

import java.lang.reflect.Type;

public class ActionPart implements ArgumentPart<Action> {

    private final Manager<String, Action> actionManager;

    public ActionPart(Manager<String, Action> actionManager) {
        this.actionManager = actionManager;
    }

    @Override
    public Action parse(ArgumentStack argumentStack) {

        if(argumentStack.hasNext()) {

            String argument = argumentStack.next();

            if(!actionManager.find(argument).isPresent()) {
                return null;
            }
            return actionManager.find(argument).get();
        }

        return null;
    }

    @Override
    public Type getType() {
        return Action.class;
    }
}
