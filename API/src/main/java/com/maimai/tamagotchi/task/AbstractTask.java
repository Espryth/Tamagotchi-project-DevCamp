package com.maimai.tamagotchi.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AbstractTask implements Task {

    private final long delay;
    private final long period;
    private final Thread thread;
    private ScheduledExecutorService service;

    public AbstractTask(Runnable runnable, long delay, long period) {
        this.delay = delay;
        this.period = period;
        this.thread = new Thread(runnable);
        this.service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(thread, delay, period, TimeUnit.SECONDS);
    }

    public long getDelay() {
        return delay;
    }

    public long getPeriod() {
        return period;
    }

    @Override
    public int getTaskId() {
        return (int)thread.getId();
    }

    @Override
    public boolean isSync() {
        return true;
    }

    @Override
    public void cancel() {
        service.shutdown();
    }
}