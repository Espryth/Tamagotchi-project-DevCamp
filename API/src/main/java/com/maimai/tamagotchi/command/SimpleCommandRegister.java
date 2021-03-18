package com.maimai.tamagotchi.command;

import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.annotation.OptArg;
import com.maimai.tamagotchi.command.part.ArgumentPart;
import com.maimai.tamagotchi.command.part.PartHandler;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.manager.ManagerImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class SimpleCommandRegister implements CommandRegister {

    private final Manager<String, RegisteredCommand> registeredCommandManager;

    private final PartHandler partHandler;

    private final String prefix;

    public SimpleCommandRegister(PartHandler partHandler,
                                 String prefix) {

        this.prefix = prefix;
        this.partHandler = partHandler;
        this.registeredCommandManager = new ManagerImpl<>();
    }

    @Override
    public void executeCommand(String argument) {

        String[] arguments = argument.split("\\s+");

        if(!arguments[0].startsWith(prefix)) return;

        Optional<RegisteredCommand> optionalCommand = registeredCommandManager.find(arguments[0].replace(prefix, ""));

        if(!optionalCommand.isPresent()) {
            System.out.println("Incorrect command please use /help");
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

                Parameter[] parameters = method.getParameters();

                registeredCommandManager.insert(method.getAnnotation(Command.class).name(), new RegisteredCommand(commandClass, method.getAnnotation(Command.class).usage(), (command, arguments) -> {

                    ArgumentStack stack = new SimpleArgumentStack(arguments);

                    List<ArgumentPart<?>> argumentPartList = new ArrayList<>();

                    List<ArgumentPart<?>> argumentPartOptList = new ArrayList<>();

                    Arrays.asList(parameters).forEach(parameter -> {

                        ArgumentPart<?> argumentPart = partHandler.corvertToArgumentPart(parameter.getType());

                        if(parameter.isAnnotationPresent(OptArg.class)) {
                            argumentPartOptList.add(argumentPart);
                            return;
                        }

                        argumentPartList.add(argumentPart);

                    });


                    if(arguments.size() > argumentPartList.size() + argumentPartOptList.size()) {
                        System.out.println("Correct usage: " + method.getAnnotation(Command.class).usage());
                        return;
                    }

                    List<Object> objectParsedList = parseAll(argumentPartList, argumentPartOptList, stack);

                    if(objectParsedList == null) {
                        System.out.println("You have a invalid argument!");
                        return;
                    }

                    try {
                        method.invoke(command, objectParsedList.toArray());
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
    public List<Object> parseAll(List<ArgumentPart<?>> argumentParts, List<ArgumentPart<?>> argumentPartsOpt, ArgumentStack argumentStack) {

        List<Object> list = new ArrayList<>();

        argumentParts.forEach(argumentPart ->  {

            Object object = argumentPart.parse(argumentStack);


            if(object == null) {
                return;
            }

            list.add(object);
        });


        argumentPartsOpt.forEach(argumentPart ->  {

            Object object = argumentPart.parse(argumentStack);


            if(object == null) {
                list.add(null);
                return;
            }

            list.add(object);
        });


        if(list.size() < argumentParts.size() || list.size() > argumentParts.size() + argumentPartsOpt.size()) {
            return null;
        }

        return list;
    }
}
