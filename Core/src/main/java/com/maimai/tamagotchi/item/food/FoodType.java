package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.DefaultType;

public enum FoodType implements DefaultType {
    APPLE("Apple", 10, 5),
    CARROT("Carrot", 15, 10),
    SEED("Seed", 15, 10),
    COOKIE("Cookie", 40, 20),
    FISH("Fish", 30, 15),
    BEEF("Beef", 50, 25);

    private final String name;
    private final double value;
    private final int cost;

    FoodType(String name, double value, int cost) {
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
