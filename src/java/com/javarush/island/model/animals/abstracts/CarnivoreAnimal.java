package com.javarush.island.model.animals.abstracts;

public abstract class CarnivoreAnimal extends Animal {

    protected CarnivoreAnimal(double weight, int maxCountOnLocation, int travelSpeed, double maxCountSaturation) {
        super(weight, maxCountOnLocation, travelSpeed, maxCountSaturation);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void selectDirection() {

    }

    @Override
    public void move() {

    }
}
