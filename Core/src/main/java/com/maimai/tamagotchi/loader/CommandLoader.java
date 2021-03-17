package com.maimai.tamagotchi.loader;

import com.maimai.tamagotchi.command.*;
import com.maimai.tamagotchi.command.part.PartHandler;
import com.maimai.tamagotchi.command.part.defaults.StringPart;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

public class CommandLoader implements Loader{

    @Override
    public void load() {
        PartHandler partHandler = new PartHandler();
        partHandler.installPart(new StringPart());

        CommandRegister commandRegister = new SimpleCommandRegister(partHandler, "/");

        commandRegister.registerCommand(new HelpCommand(), new OpenCommand(), new ShopCommand());
    }
}
