package com.javarush.island.activity;

import com.javarush.island.model.animals.abstracts.ObjectIsland;
import com.javarush.island.model.animals.carnivore.*;
import com.javarush.island.model.animals.herbivore.*;
import com.javarush.island.model.plant.Plant;

public class ObjectIslandFactory {

    public ObjectIsland creatIsland(TypesOnIsland type) {

        ObjectIsland objectIsland = null;
        switch (type) {
            case BEAR -> objectIsland = new Bear();
            case BOA_CONSTRICTOR -> objectIsland = new Boa();
            case EAGLE -> objectIsland = new Eagle();
            case FOX -> objectIsland = new Fox();
            case WOLF -> objectIsland = new Wolf();
            case BUFFALO -> objectIsland = new Buffalo();
            case CATERPILLAR -> objectIsland = new Caterpillar();
            case DEER -> objectIsland = new Deer();
            case DUCK -> objectIsland = new Duck();
            case GOAT -> objectIsland = new Goat();
            case HOG -> objectIsland = new Hog();
            case HORSE -> objectIsland = new Horse();
            case MOUSE -> objectIsland = new Mouse();
            case RABBIT -> objectIsland = new Rabbit();
            case SHEEP -> objectIsland = new Sheep();
            case PLANT -> objectIsland = new Plant();
            default -> {
            }
        }
        return objectIsland;
    }
}
