package com.maimai.tamagotchi.event.game;

import com.maimai.tamagotchi.event.Event;

public class GameEndEvent extends Event {

    private final GameEndCause cause;

    public GameEndEvent(GameEndCause cause) {
        this.cause = cause;
    }


    public GameEndCause getCause() {
        return cause;
    }
}
