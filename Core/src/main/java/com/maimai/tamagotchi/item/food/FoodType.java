package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.DefaultType;

public enum FoodType implements DefaultType {
    APPLE("Manzana", 50, 10), FISH("Pescado", 30, 10);

    private final String name;
    private final double value;
    private final double cost;

    FoodType(String name, double value, double cost) {
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
    public double getCost() {
        return cost;
    }
}
