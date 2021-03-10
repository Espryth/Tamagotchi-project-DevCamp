package com.maimai.tamagotchi.scheduler;

public interface Task {

    int getTaskId();

    boolean isSync();

    boolean isCancelled();

    void cancel();
}