package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.command.annotation.Command;

public class ExitCommand implements CommandClass {

    private final ProgramCore core;

    public ExitCommand(ProgramCore core) {
        this.core = core;
    }


    @Command(name = "exit", usage = "/exit")
    public void executeExitCommand() {
        core.setEnabled(false);
    }
}
