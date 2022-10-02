package org.example;

public class CatFactory {
    public CatFactory() {
    }

    public static Cat createCat(String name, int weight) throws IncorrectCatWeightException {

        try {
            return new Cat(name, weight, false);
        } catch (IncorrectCatWeightException e) {
            return new Cat(name, 5, true);
        }

    }
}
