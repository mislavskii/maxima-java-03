package org.example;

public class Dog<T> {
    private T id;
    private String name;
    private int weight;
    private boolean isAngry;

    public Dog(String name, int weight) {
        this.id = null;
        this.isAngry = false;
        this.name = name;
        this.weight = weight;
    }

    public Dog(String name, int weight, boolean isAngry) {
        this.id = null;
        this.isAngry = isAngry;
        this.name = name;
        this.weight = weight;
    }

    public Dog(String name, int weight, boolean isAngry, T id) {
        this.name = name;
        this.id = id;
        this.isAngry = isAngry;
        this.setWeight(weight);
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isAngry() {
        return isAngry;
    }

    public void setAngry(boolean angry) {
        isAngry = angry;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
