package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.event.EventRegister;

public interface ProgramCore {

    void initCore();

    EventRegister getEventRegister();

    CommandRegister getCommandRegister();
}
