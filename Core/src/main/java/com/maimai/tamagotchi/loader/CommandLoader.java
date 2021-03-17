package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.command.OpenCommand;
import com.maimai.tamagotchi.command.SimpleCommandRegister;
import com.maimai.tamagotchi.command.part.PartHandler;

public class CommandLoader {

    private SimpleCommandRegister simpleCommandRegister;

    public CommandLoader(){
        setup();
    }

    private void setup(){
        simpleCommandRegister = new SimpleCommandRegister(new PartHandler(), "Tamagochi");
        simpleCommandRegister.registerCommand(new OpenCommand());
    }

    public SimpleCommandRegister getCommandRegister(){
        return simpleCommandRegister;
    }
}
