package com.maimai.tamagotchi.scheduler;

import com.maimai.tamagotchi.task.SimpleTask;
import com.maimai.tamagotchi.task.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TamagotchiScheduler implements Scheduler {

    private final Map<Integer, Task> taskMap;

    public TamagotchiScheduler() {
        this.taskMap = new HashMap<>();
    }

    @Override
    public Task runTask(Runnable runnable, long delay, long period, TimeUnit timeUnit) throws IllegalArgumentException {
        Task task = new SimpleTask(runnable, delay, period, timeUnit);
        return taskMap.put(task.getTaskId(), task);
    }

    @Override
    public void cancelTask(int id) {
        taskMap.get(id).cancel();
    }
}