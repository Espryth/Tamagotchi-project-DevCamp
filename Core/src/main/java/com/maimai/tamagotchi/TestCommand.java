package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandClass;
import com.maimai.tamagotchi.command.annotation.Command;
import com.maimai.tamagotchi.command.annotation.OptArg;

public class TestCommand implements CommandClass {

    @Command(name = "poto", usage = "poto")
    public void onPoto(String poto, @OptArg String optString) {
        System.out.println(poto);
        if(optString != null) {
            System.out.println(optString);
        }
    }
}
