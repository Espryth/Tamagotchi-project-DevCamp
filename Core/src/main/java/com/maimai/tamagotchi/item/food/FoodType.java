package com.maimai.tamagotchi.item.food;

import com.maimai.tamagotchi.item.DefaultType;

public enum FoodType implements DefaultType {
    SEED("Seed", 15, 10), //Hamster,parrot
    APPLE("Apple", 10, 5), //Hamster,parrot
    BERRIE("Berrie", 15, 10), //Hamster,parrot
    MANGO("Mango", 30, 15), //Hamster,parrot
    CARROT("Carrot", 15, 10), //Hamster,parrot,rabbit
    LETTUCE("Lettuce", 50, 25), //Hamster,parrot,rabbit
    FISH("Fish", 30, 15), //Cat,dog
    BEEF("Beef", 50, 25), //Cat,dog
    CHICKEN("Chicken", 15, 10); //Cat,dog

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
