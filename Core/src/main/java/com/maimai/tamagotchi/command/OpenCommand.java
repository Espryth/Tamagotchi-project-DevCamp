package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.module.Module;

public class OpenCommand implements CommandClass {

    @Command(name = "open")
    public void onExecuteOpenCommand(Module module) {
        module.start();
    }
}
