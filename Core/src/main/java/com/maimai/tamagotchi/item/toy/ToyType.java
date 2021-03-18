package com.maimai.tamagotchi.item.toy;

import com.maimai.tamagotchi.item.DefaultType;

public enum ToyType implements DefaultType {
    WHEEL("Wheel", 50, 25), //Hamster
    LABYRINTH("Labyrinth", 40, 25), //Hamster
    RUBBER_BONE("Rubber_bone", 40, 25), //Dog
    BALL("Ball", 50, 25), //Dog
    ROPE("Rope", 50, 25), //Cat
    POINTER("Pointer", 40, 25); //Cat

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
