package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.part.ArgumentPart;

import java.util.List;

public interface CommandRegister {

    void executeCommand(String argument);

    void registerCommand(CommandClass commandClass);

    void registerCommand(CommandClass... commandClasses);

    List<Object> parseAll(List<ArgumentPart<?>> argumentParts, List<ArgumentPart<?>> argumentPartsOpt, ArgumentStack argumentStack);

}
