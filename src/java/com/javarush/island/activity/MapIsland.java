package com.javarush.island.activity;

public class MapIsland {

    private int wightIsland;

    private int lengthIsland;

    private Location[][] locations;

    public MapIsland(int lengthIsland, int wightIsland) {
        this.wightIsland = wightIsland;
        this.lengthIsland = lengthIsland;
        this.locations = new Location[getLengthIsland()][getWightIsland()];
    }

    public int getWightIsland() {
        return wightIsland;
    }

    public int getLengthIsland() {
        return lengthIsland;
    }

    public void createLocations(){

        for (int posX = 0; posX < getLengthIsland(); posX++) {
            for (int posY = 0; posY < getWightIsland(); posY++) {
                locations[posX][posY] = new Location(posX, posY);
            }
        }
    }

    public void fillingLocations(){
        for (int posX = 0; posX < locations.length; posX++) {
            for (int posY = 0; posY < locations[posX].length; posY++) {

                locations[posX][posY].addObjectInLocation();
            }
        }
    }

    public void printStatistic() {
        for (int posX = 0; posX < locations.length; posX++) {
            for (int posY = 0; posY < locations[posX].length; posY++) {

                System.out.print("[ " + locations[posX][posY].getStatistic() + " ]");
            }
            System.out.println();
        }
    }

    public void movingAroundLocations(){
        for (int posX = 0; posX < locations.length; posX++) {
            for (int posY = 0; posY < locations[posX].length; posY++) {
                locations[posX][posY].moveObjectFromLocation();

                int newPosX;
                if (posX < locations.length-1) {
                    newPosX = posX + 1;
                } else {
                    newPosX = posX;
                }

                System.out.print("[ " + locations[newPosX][posY].getObj() + " ]");
            }
            System.out.println();
        }
    }


    public void clearingLocations(){
        for (int posX = 0; posX < locations.length; posX++) {
            for (int posY = 0; posY < locations[posX].length; posY++) {

                locations[posX][posY].removeObjectFromLocation();
            }
        }
    }

    public void printStatisticOneStep() {
        for (int posX = 0; posX < locations.length; posX++) {
            for (int posY = 0; posY < locations[posX].length; posY++) {

                System.out.print("[ " + locations[posX][posY].getStatisticOneStep() + " ]");
            }
            System.out.println();
        }
    }
}
