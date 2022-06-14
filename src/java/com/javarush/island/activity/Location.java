package com.javarush.island.activity;

import com.javarush.island.model.animals.abstracts.Animal;
import com.javarush.island.model.animals.abstracts.ObjectIsland;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Location {

    private int posX;

    private int posY;

    private ObjectIslandFactory factory;

    private List<Animal> animalList;

    private List<ObjectIsland> obj;

    private List<ObjectIsland> addObjectList;

    private Map<String, Integer> statisticByObjectIsland;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    private ObjectIsland getObjectPlant() {
        return factory.creatIsland(TypesOnIsland.PLANT);
    }

    private ObjectIsland getRandomObject() {
        TypesOnIsland[] typesOnIsland = TypesOnIsland.values();
        int size = typesOnIsland.length;
        TypesOnIsland typeOnIsland = typesOnIsland[ThreadLocalRandom.current().nextInt(size)];
        return factory.creatIsland(typeOnIsland);
    }

    public Location(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.factory = new ObjectIslandFactory();
        this.animalList = new ArrayList<>();
        this.addObjectList = new ArrayList<>();
        this.statisticByObjectIsland = new HashMap<>();
        this.obj = new ArrayList<>();
    }

    public List<Animal> getAnimalList() {
        TypesOnIsland[] typesOnIsland = TypesOnIsland.values();

        for (TypesOnIsland type : typesOnIsland) {
            if (!TypesOnIsland.PLANT.equals(type)){
                animalList.add((Animal) factory.creatIsland(type));
            }
        }
        return animalList;
    }

    public List<ObjectIsland> addObjectInLocation(){

        int rndPlant = ThreadLocalRandom.current().nextInt(1, getObjectPlant().getMaxCountOnLocation());;

        for (int i = 0; i < rndPlant; i++) {
            addObjectList.add(getObjectPlant());

        }

        int rnd = ThreadLocalRandom.current().nextInt(1, getRandomObject().getMaxCountOnLocation());

        for (int i = 0; i < rnd; i++) {
            addObjectList.add(getRandomObject());

        }
        return addObjectList;
    }

    public List<ObjectIsland> removeObjectFromLocation(){
        for (int j = 0; j < addObjectList.size(); j++) {
            String stringNameObject = addObjectList.get(j).getClass().getSimpleName();
            int countObject = statisticByObjectIsland.getOrDefault(stringNameObject,0);
            if (countObject > 1){
                statisticByObjectIsland.put(stringNameObject,countObject - 1);
                addObjectList.remove(j);
            } else {
                statisticByObjectIsland.remove(stringNameObject);
                addObjectList.remove(j);
            }
        }
        return addObjectList;
    }
    public List<ObjectIsland> moveObjectFromLocation(){
        Iterator<ObjectIsland> iter = addObjectList.iterator();
        while (iter.hasNext()) {
            obj.add(iter.next());
            iter.remove();
        }
        return addObjectList;
    }

    public String getStatistic(){

        for (int j = 0; j < addObjectList.size(); j++) {
            String stringNameObject = addObjectList.get(j).getClass().getSimpleName();
            if (!statisticByObjectIsland.containsKey(stringNameObject)){
                statisticByObjectIsland.put(stringNameObject,1);
            } else if(statisticByObjectIsland.get(stringNameObject) < addObjectList.get(j).getMaxCountOnLocation()){
                statisticByObjectIsland.put(stringNameObject,statisticByObjectIsland.get(stringNameObject) + 1);
            }
        }
        String statistic = "";
        for (Map.Entry<String, Integer> entry : statisticByObjectIsland.entrySet()) {
            statistic += entry.getKey() + " -> " + entry.getValue() + " ";
        }
        return statistic;
    }

    public String getStatisticOneStep(){
        String statistic = "";
        for (Map.Entry<String, Integer> entry : statisticByObjectIsland.entrySet()) {
            statistic += entry.getKey() + " -> " + entry.getValue() + " ";
        }
        return statistic;
    }

    public List<ObjectIsland> getAddObjectList() {
        return addObjectList;
    }

    public List<ObjectIsland> getObj() {
        return obj;
    }
}
