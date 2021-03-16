package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.manager.ManagerImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class SimpleCommandRegister implements CommandRegister {

    private final Manager<RegisteredCommand> registeredCommandManager;

    private final Set<ArgumentPart<?>> argumentParts;

    private final String prefix;

    public SimpleCommandRegister(String prefix) {
        this.prefix = prefix;
        this.registeredCommandManager = new ManagerImpl<>();
        this.argumentParts = new HashSet<>();
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

                    try {
                        method.invoke(command, arguments.toArray());
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
    public void installPart(ArgumentPart<?> part) {
        argumentParts.add(part);
    }

    @Override
    public void installPart(ArgumentPart<?>... parts) {
        for (ArgumentPart<?> part : parts) {
            installPart(part);
        }
    }

    @Override
    public List<Object> parseAll(ArgumentStack argumentStack) {

        List<Object> list = new ArrayList<>();

        for(ArgumentPart<?> part : argumentParts) {
            list.add(part.parse(argumentStack));
        }

        return list;
    }
}
