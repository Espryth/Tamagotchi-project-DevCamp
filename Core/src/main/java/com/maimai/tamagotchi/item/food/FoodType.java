package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.DefaultType;

public enum FoodType implements DefaultType {
    SEED("Seed", 15, 10),
    APPLE("Apple", 10, 5),
    BERRIE("Berrie", 15, 10),
    MANGO("Mango", 30, 15),
    CARROT("Carrot", 15, 10),
    LETTUCE("Lettuce", 50, 25),
    FISH("Fish", 30, 15),
    BEEF("Beef", 50, 25),
    CHICKEN("Chicken", 15, 10);

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
