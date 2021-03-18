package com.maimai.tamagotchi.item.toy;

import com.maimai.tamagotchi.item.DefaultType;

public enum ToyType implements DefaultType {
    TOY("Juguete simple", 50, 10);

    private final String name;
    private final double value;
    private final int cost;

    ToyType(String name, double value, int cost) {
        this.name = name;
        this.value = value;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
