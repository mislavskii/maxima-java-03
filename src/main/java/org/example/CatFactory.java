package org.example;

public class CatFactory {

    public static Cat createCat(String name, int weight) throws IncorrectCatWeightException {

        try {
            return new Cat(name, weight);
        } catch (IncorrectCatWeightException e) {
            return new Cat(name, 5, true);
        }

    }
}
