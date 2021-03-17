package com.maimai.tamagotchi.command.part.defaults;

import com.maimai.tamagotchi.command.ArgumentStack;
import com.maimai.tamagotchi.command.exception.ArgumentParseException;
import com.maimai.tamagotchi.command.part.ArgumentPart;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.module.Module;

import java.lang.reflect.Type;

public class ModulePart implements ArgumentPart<Module> {

    private final Manager<String, Module> moduleManager;

    public ModulePart(Manager<String, Module> moduleManager) {
        this.moduleManager = moduleManager;
    }

    @Override
    public Module parse(ArgumentStack argumentStack) {

        if(argumentStack.hasNext()) {
            if(!moduleManager.find(argumentStack.next()).isPresent()) {
                throw new ArgumentParseException("No se pudo pa");
            }
            return moduleManager.find(argumentStack.next()).get();
        }

        return null;
    }

    @Override
    public Type getType() {
        return Module.class;
    }
}
