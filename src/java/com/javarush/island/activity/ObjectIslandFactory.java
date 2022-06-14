package com.javarush.island.activity;

import com.javarush.island.model.animals.abstracts.ObjectIsland;
import com.javarush.island.model.animals.carnivore.*;
import com.javarush.island.model.animals.herbivore.*;
import com.javarush.island.model.plant.Plant;

public class ObjectIslandFactory {

    public ObjectIsland creatIsland(TypesOnIsland type) {

        ObjectIsland island = null;
        switch (type) {
            case BEAR -> island = new Bear();
            case BOA_CONSTRICTOR -> island = new BoaConstrictor();
            case EAGLE -> island = new Eagle();
            case FOX -> island = new Fox();
            case WOLF -> island = new Wolf();
            case BUFFALO -> island = new Buffalo();
            case CATERPILLAR -> island = new Caterpillar();
            case DEER -> island = new Deer();
            case DUCK -> island = new Duck();
            case GOAT -> island = new Goat();
            case HOG -> island = new Hog();
            case HORSE -> island = new Horse();
            case MOUSE -> island = new Mouse();
            case RABBIT -> island = new Rabbit();
            case SHEEP -> island = new Sheep();
            case PLANT -> island = new Plant();
            default -> {
            }
        }
        return island;
    }
}
