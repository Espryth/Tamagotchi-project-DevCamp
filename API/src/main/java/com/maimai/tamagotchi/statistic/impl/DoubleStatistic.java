package com.maimai.tamagotchi.statistic.impl;

import com.maimai.tamagotchi.statistic.Statistic;

public class DoubleStatistic implements Statistic<Double> {

    private double value;

    public DoubleStatistic(int value) {
        this.value = value;
    }

    public DoubleStatistic() {
        this(0);
    }

    @Override
    public void increase(Double value) {
        if(!(this.value + value > 100)) {
            this.value += value;
        }
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
