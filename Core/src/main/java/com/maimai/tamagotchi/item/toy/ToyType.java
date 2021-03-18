package com.maimai.tamagotchi.item.toy;

import com.maimai.tamagotchi.item.DefaultType;

public enum ToyType implements DefaultType {
    LABYRINTH("Labyrinth", 50, 10),
    RUBBER_BONE("Rubber_bone", 50, 20),
    BALL("Ball", 100, 50),
    FORAGING("Foraging", 40, 25),
    POINTER("Pointer", 60, 45);

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
