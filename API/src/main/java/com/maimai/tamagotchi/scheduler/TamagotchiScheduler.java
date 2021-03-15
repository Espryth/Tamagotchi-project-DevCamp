package com.maimai.tamagotchi.scheduler;

import com.maimai.tamagotchi.task.AbstractTask;
import com.maimai.tamagotchi.task.Task;

import java.util.HashMap;
import java.util.Map;

public class TamagotchiScheduler implements Scheduler {

    private final Map<Integer, Task> taskMap;

    public TamagotchiScheduler() {
        this.taskMap = new HashMap<>();
    }

    @Override
    public Task runTask(Runnable runnable, long delay, long period) throws IllegalArgumentException {
        Task task = new AbstractTask(runnable, delay, period);
        return taskMap.put(task.getTaskId(), task);
    }

    @Override
    public void cancelTask(int id) {
        taskMap.get(id).cancel();
    }

    public Map<Integer, Task> getTaskMap() {
        return taskMap;
    }
}