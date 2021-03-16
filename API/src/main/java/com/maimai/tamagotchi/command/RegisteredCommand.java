package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.player.Player;

public class RegisteredCommand {

    private final CommandClass commandClass;

    private final CommandExecutor commandExecutor;

    public RegisteredCommand(CommandClass commandClass, CommandExecutor commandExecutor) {
        this.commandClass = commandClass;
        this.commandExecutor = commandExecutor;
    }

    public CommandClass getCommandClass() {
        return commandClass;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }
}
