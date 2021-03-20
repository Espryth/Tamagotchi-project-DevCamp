package com.maimai.tamagotchi.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimpleTask implements Task {

    private final long delay;
    private final long period;
    private final Thread thread;
    private ScheduledExecutorService service;
    private TimeUnit timeUnit;

    public SimpleTask(Runnable runnable, long delay, long period, TimeUnit timeUnit) {
        this.delay = delay;
        this.period = period;
        this.thread = new Thread(runnable);
        this.service = Executors.newSingleThreadScheduledExecutor();
        this.timeUnit = timeUnit;
        service.scheduleAtFixedRate(thread, delay, period, timeUnit);
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

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    @Override
    public void cancel() {
        service.shutdown();
    }
}