package com.maimai.tamagotchi.item.bath;

import com.maimai.tamagotchi.item.DefaultType;

public enum BathType implements DefaultType {
    DOGSOAP("Shampoo de perro", 50, 10), CATSOAP("Shampoo de gato", 50, 20);

    private final String name;
    private final double value;
    private final int cost;

    BathType(String name, double value, int cost) {
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
