package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.command.HelpCommand;
import com.maimai.tamagotchi.command.SimpleCommandRegister;
import com.maimai.tamagotchi.command.part.PartHandler;
import com.maimai.tamagotchi.command.part.defaults.StringPart;
import com.maimai.tamagotchi.event.EventRegister;

import java.util.Scanner;

public class TamagotchiMain {

    public static void main(String[] args) {

        ProgramCore core = new TamagotchiCore();
        core.initCore();

    }

}
