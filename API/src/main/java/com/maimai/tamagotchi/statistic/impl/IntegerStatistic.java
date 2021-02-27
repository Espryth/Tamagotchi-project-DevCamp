package com.maimai.tamagotchi.statistic.impl;

import com.maimai.tamagotchi.statistic.Statistic;

public class IntegerStatistic implements Statistic<Integer> {

    private int value;

    @Override
    public void increase(Integer value) {
        this.value += value;
    }

    @Override
    public void decrement(Integer value) {
        this.value -= value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
}
