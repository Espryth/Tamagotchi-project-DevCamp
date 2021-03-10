package com.maimai.tamagotchi.event;

import com.maimai.tamagotchi.event.listener.Listener;
import com.maimai.tamagotchi.event.listener.RegisteredListener;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class SimpleEventRegister implements EventRegister {


    private final Set<RegisteredListener> registeredListeners;

    public SimpleEventRegister() {
        this.registeredListeners = new HashSet<>();
    }

    @Override
    public void callEvent(Event event) {

        for(RegisteredListener registeredListener : registeredListeners) {
            registeredListener.getEventExecutor().execute(
                    registeredListener.getListener(),
                    event
            );
        }
    }

    @Override
    public void registerEvents(Listener... listeners) {

        for(Listener listener : listeners) {

            Method[] methods = listener.getClass().getMethods();

            for(Method method : methods) {

                if(method.isAnnotationPresent(EventHandler.class)) {

                    registeredListeners.add(new RegisteredListener(listener, (l, e) -> {
                        try {
                            method.invoke(l, e);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    ));
                }
            }
        }
    }
}
