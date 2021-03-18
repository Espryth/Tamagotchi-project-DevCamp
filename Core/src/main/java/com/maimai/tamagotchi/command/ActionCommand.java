package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;

public class ActionCommand implements CommandClass {

    @Command(
            name = "action",
            usage = "/action [action] <item>"
    )
    public void executeActionCommand(){}

}
