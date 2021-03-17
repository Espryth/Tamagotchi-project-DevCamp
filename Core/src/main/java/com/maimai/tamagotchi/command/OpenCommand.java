package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.module.Module;

public class OpenCommand implements CommandClass {

    @Command(name = "open", usage = "/open <module>")
    public void executeOpenCommand(Module module) {
        module.start();
    }
}
