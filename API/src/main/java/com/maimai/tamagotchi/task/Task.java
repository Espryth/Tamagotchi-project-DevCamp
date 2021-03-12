package com.maimai.tamagotchi.task;

public interface Task {
    int getTaskId();

    boolean isSync();

    void cancel();
}