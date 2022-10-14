package org.example;

import java.util.ArrayList;

public class StackKitchen<T> extends QueueKitchen<T> {

    @Override
    public void feed() {
        if (animals.size() > 0) {
            animals.remove(animals.size() - 1);
        }
    }
}
