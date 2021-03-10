package com.maimai.tamagotchi.event;

public class RegisteredListener {

    private final Listener listener;

    private final EventExecutor eventExecutor;

    public RegisteredListener(Listener listener, EventExecutor eventExecutor) {
        this.listener = listener;
        this.eventExecutor = eventExecutor;
    }

    public Listener getListener() {
        return listener;
    }

    public EventExecutor getEventExecutor() {
        return eventExecutor;
    }
}
