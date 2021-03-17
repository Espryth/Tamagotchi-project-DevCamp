package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandClass;
import com.maimai.tamagotchi.command.annotation.Command;

public class TestCommand implements CommandClass {

    @Command(name = "poto", usage = "poto")
    public void onPoto(String a, Double b) {
        System.out.println(a);
        System.out.println(b);
    }
}
