package org.example;

import java.util.ArrayList;

public class QueueKitchen implements AnimalKitchen {

    private ArrayList<Object> animals = new ArrayList<>();

    public ArrayList<Object> getAnimals() {
        return animals;
    }

    public void add(Object animal) {
        animals.add(animal);
    }

    @Override
    public void feed() {
        animals.remove(0);
    }
}
