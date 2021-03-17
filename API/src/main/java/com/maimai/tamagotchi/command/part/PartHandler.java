package com.maimai.tamagotchi.command.part;

import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.manager.ManagerImpl;

public class PartHandler {

    private final Manager<Class<?>, ArgumentPart<?>> argumentPartManager;

    public PartHandler() {
        this.argumentPartManager = new ManagerImpl<>();
    }

    public ArgumentPart<?> tryParseArgument(Class<?> clazz) {

        if(!argumentPartManager.find(clazz).isPresent()) {
            System.out.println("POTO");
            return null;
        }

        return argumentPartManager.find(clazz).get();
    }

    public void installPart(ArgumentPart<?> argumentPart) {
        argumentPartManager.insert((Class<?>) argumentPart.getType(), argumentPart);
    }

}
