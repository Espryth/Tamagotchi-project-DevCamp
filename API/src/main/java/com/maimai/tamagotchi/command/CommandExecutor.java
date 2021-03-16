package com.maimai.tamagotchi.command;

import java.util.List;

@FunctionalInterface
public interface CommandExecutor {
    void execute(CommandClass commandClass, List<String> arguments);
}
