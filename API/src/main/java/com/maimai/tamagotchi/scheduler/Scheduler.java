package com.maimai.tamagotchi.scheduler;

public interface Scheduler {

    Task runTask(Runnable runnable, long delay, long period) throws IllegalArgumentException;

}