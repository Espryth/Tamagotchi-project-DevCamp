package com.maimai.tamagotchi.scheduler;

import com.maimai.tamagotchi.task.Task;

import java.util.concurrent.TimeUnit;

public interface Scheduler {

    Task runTask(Runnable runnable, long delay, long period, TimeUnit unit) throws IllegalArgumentException;

    void cancelTask(int id);
}