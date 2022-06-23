package com.javarush.island.model.animals.herbivore;

import com.javarush.island.model.animals.abstracts.HerbivoreAnimal;

public class Mouse extends HerbivoreAnimal {
    public Mouse() {
        super(0.05, 500, 1, 0.01);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void eat() {

    }
}
