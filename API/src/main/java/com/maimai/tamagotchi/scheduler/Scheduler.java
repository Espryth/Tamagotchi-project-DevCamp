package com.maimai.tamagotchi.scheduler;

import com.maimai.tamagotchi.task.Task;

public interface Scheduler {

    Task runTask(Runnable runnable, long delay, long period) throws IllegalArgumentException;

    void cancelTask(int id);
}