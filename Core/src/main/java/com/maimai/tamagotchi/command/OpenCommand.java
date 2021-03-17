package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.module.MainModule;
import com.maimai.tamagotchi.module.Module;

public class OpenCommand implements CommandClass {

    @Command(name = "open")
    public void onExecuteOpenCommand() {
        System.out.println("test1");
        Module module = new MainModule();
        module.start();
    }
}
