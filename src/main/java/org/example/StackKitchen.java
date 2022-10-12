package org.example;

import java.util.ArrayList;

public class StackKitchen implements AnimalKitchen {

    private ArrayList<Object> animals = new ArrayList<>();

    public ArrayList<Object> getAnimals() {
        return animals;
    }

    @Override
    public void add(Object animal) {
        animals.add(animal);
    }

    @Override
    public void feed() {
        if (animals.size() > 0) {
            animals.remove(animals.size() - 1);
        }
    }
}
