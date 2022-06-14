package com.javarush.island.activity;

public class Management {

    public void start(){

        MapIsland mapIsland = new MapIsland(100,20);
        mapIsland.createLocations();
        mapIsland.fillingLocations();
        mapIsland.printStatistic();
        //mapIsland.clearingLocations();
        //mapIsland.movingAroundLocations();
        //mapIsland.printStatisticOneStep();
    }
}
