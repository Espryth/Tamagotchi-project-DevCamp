package com.maimai.tamagotchi.task;

public abstract class AbstractTask implements Task {

    private final int id;
    private final boolean sync;
    private final Runnable runnable;
    private final long delay;
    private final long period;

    public AbstractTask(int id, boolean sync, Runnable runnable, long delay, long period) {
        this.id = id;
        this.sync = sync;
        this.runnable = runnable;
        this.delay = delay;
        this.period = period;
    }

    @Override
    public int getTaskId() {
        return id;
    }

    @Override
    public boolean isSync() {
        return sync;
    }

    public int getId() {
        return id;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getDelay() {
        return delay;
    }

    public long getPeriod() {
        return period;
    }

    @Override
    public void cancel() {
    }
}