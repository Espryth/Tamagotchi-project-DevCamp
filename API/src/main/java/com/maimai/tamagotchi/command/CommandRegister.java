package com.maimai.tamagotchi.command;

import java.util.List;

public interface CommandRegister {

    void executeCommand(String argument);

    void registerCommand(CommandClass commandClass);

    void registerCommand(CommandClass... commandClasses);

    void installPart(ArgumentPart<?> part);

    void installPart(ArgumentPart<?>... parts);

    List<Object> parseAll(ArgumentStack argumentStack);

}
