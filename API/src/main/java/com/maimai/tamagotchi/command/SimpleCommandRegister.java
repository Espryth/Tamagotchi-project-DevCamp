package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.part.ArgumentPart;
import com.maimai.tamagotchi.command.part.PartHandler;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.manager.ManagerImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class SimpleCommandRegister implements CommandRegister {

    private final Manager<String, RegisteredCommand> registeredCommandManager;

    private final PartHandler partHandler;

    private final String prefix;

    public SimpleCommandRegister(PartHandler partHandler, String prefix) {
        this.prefix = prefix;
        this.partHandler = partHandler;
        this.registeredCommandManager = new ManagerImpl<>();
    }

    @Override
    public void executeCommand(String argument) {

        String[] arguments = argument.split("\\s+");

        Optional<RegisteredCommand> optionalCommand = registeredCommandManager.find(arguments[0].replace(prefix, ""));

        if(!optionalCommand.isPresent()) {
            System.out.println("Comando incorrecto");
            return;
        }

        RegisteredCommand command = optionalCommand.get();

        List<String> argumentList = new ArrayList<>(Arrays.asList(arguments));

        argumentList.remove(0);

        command.getCommandExecutor().execute(command.getCommandClass(), argumentList);
    }

    public void registerCommand(CommandClass commandClass) {

        Class<? extends CommandClass> clazz = commandClass.getClass();

        for(Method method : clazz.getMethods()) {

            if(method.isAnnotationPresent(Command.class)) {

                registeredCommandManager.insert(method.getAnnotation(Command.class).name(), new RegisteredCommand(commandClass, (command, arguments) -> {

                    ArgumentStack stack = new SimpleArgumentStack(arguments);

                    List<ArgumentPart<?>> argumentPartList = new ArrayList<>();

                    arguments.forEach(argument -> {

                        ArgumentPart<?> argumentPart = partHandler.tryParseArgument(argument.getClass());

                        if(argumentPart != null) {
                            argumentPartList.add(argumentPart);
                        }
                    });

                    try {
                        method.invoke(command, parseAll(argumentPartList, stack).toArray());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }));

            }
        }
    }

    @Override
    public void registerCommand(CommandClass... commandClasses) {
        for (CommandClass commandClass : commandClasses) {
            registerCommand(commandClass);
        }
    }

    @Override
    public List<Object> parseAll(List<ArgumentPart<?>> argumentParts, ArgumentStack argumentStack) {

        List<Object> list = new ArrayList<>();

        argumentParts.forEach(argumentPart -> list.add(argumentPart.parse(argumentStack)));

        return list;
    }
}
