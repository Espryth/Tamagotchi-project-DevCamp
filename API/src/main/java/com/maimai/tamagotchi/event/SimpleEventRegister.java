package com.maimai.tamagotchi.event;

import com.maimai.tamagotchi.event.listener.Listener;
import com.maimai.tamagotchi.event.listener.RegisteredListener;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.manager.ManagerImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SimpleEventRegister implements EventRegister {

    private final Manager<Class<? extends Event>, Set<RegisteredListener>> registeredListenerManager;

    public SimpleEventRegister() {
        this.registeredListenerManager = new ManagerImpl<>();
    }

    @Override
    public void callEvent(Event event) {

        Optional<Set<RegisteredListener>> listeners = registeredListenerManager.find(event.getClass());

        listeners.ifPresent(listenerSet ->
                listenerSet.forEach(registeredListener ->
                        registeredListener.getEventExecutor().execute(registeredListener.getListener(), event)
                )
        );

    }

    @Override
    public void registerEvents(Listener listener) {

        Method[] methods = listener.getClass().getDeclaredMethods();

        for(Method method : methods) {

            if(method.isAnnotationPresent(EventHandler.class)) {

                Parameter[] parameters = method.getParameters();
                Class<? extends Event> clazz = (Class<? extends Event>) parameters[0].getType();

                RegisteredListener registeredListener = new RegisteredListener(listener, (l, e) -> {
                    try {
                        method.invoke(l, e);
                    } catch (IllegalAccessException | InvocationTargetException exception) {
                        exception.printStackTrace();
                    }
                });

                if(!registeredListenerManager.find(clazz).isPresent()) {
                    Set<RegisteredListener> set  = new HashSet<>();

                    set.add(registeredListener);

                    registeredListenerManager.insert(clazz, set);
                }

                Set<RegisteredListener> set = registeredListenerManager.find(clazz).get();
                set.add(registeredListener);

            }
        }
    }

    @Override
    public void registerEvents(Listener... listeners) {
        for(Listener listener : listeners) {
            registerEvents(listener);
        }
    }
}
