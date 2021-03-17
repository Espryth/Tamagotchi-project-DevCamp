package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.event.EventRegister;

public class TamagotchiCore implements ProgramCore {
    @Override
    public void initCore() {

    }

    @Override
    public EventRegister getEventRegister() {
        return null;
    }

    @Override
    public CommandRegister getCommandRegister() {
        return null;
    }
}
