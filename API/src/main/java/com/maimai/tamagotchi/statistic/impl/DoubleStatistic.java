package com.maimai.tamagotchi.statistic.impl;

import com.maimai.tamagotchi.statistic.Statistic;

public class DoubleStatistic implements Statistic<Double> {

    private double value;

    @Override
    public void increase(Double value) {
        this.value += value;
    }

    @Override
    public void decrement(Double value) {
        this.value -= value;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void setValue(Double value) {
        this.value = value;
    }
}
