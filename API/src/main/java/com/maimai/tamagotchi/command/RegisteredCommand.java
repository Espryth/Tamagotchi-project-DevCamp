package com.maimai.tamagotchi.command;

import java.lang.reflect.Parameter;

public class RegisteredCommand {

    private final CommandClass commandClass;

    private final CommandExecutor commandExecutor;

    private final String usage;

    public RegisteredCommand(CommandClass commandClass, String usage, CommandExecutor commandExecutor) {
        this.commandClass = commandClass;
        this.usage = usage;
        this.commandExecutor = commandExecutor;
    }

    public CommandClass getCommandClass() {
        return commandClass;
    }

    public String getUsage() {
        return usage;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }
}
