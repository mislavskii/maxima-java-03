package org.example;


/*
* TODO
Описать класс Dog с методами аналогичными классу Cat, но не имеющего с ним общих предков.
Описать интерфейс AnimalKitchen — описывает кормление группы любых животных. Методы:
void add ( экземпляр животного) — добавить животное в очередь.
void feed() - покормить очередное животное (исключить его из очереди на кормление).
Описать два класса QueueKitchen и StackKitchen, реализующие кормление животных по принципам FIFO и LIFO соответственно.
Подсказка: В каждом классе должно быть определено свойство animals типа ArrayList
*/


import java.util.ArrayList;

public class App {
    public static void main( String[] args ) throws IncorrectCatWeightException {

        Cat<String> murke = new Cat<>("Murke", 3);
        murke.setId("M0422");

        Cat<Long> barseg = new Cat<>("Barseg", 5);
        barseg.setId(666L);

        Cat murzeg = new Cat("Murzeg", 7);

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(murzeg);
        cats.add(barseg);
        cats.add(murke);

        System.out.println(cats.size());
        System.out.println(cats.get(0));

        for(Cat cat : cats) System.out.println(cat);
        System.out.println();

        QueueKitchen qK = new QueueKitchen();
        for (Cat cat : cats) qK.add(cat);
        System.out.println(qK.getAnimals());
        qK.feed();
        System.out.println(qK.getAnimals());
        System.out.println();

        StackKitchen sK = new StackKitchen();
        for (Cat cat : cats) sK.add(cat);
        System.out.println(sK.getAnimals());
        sK.feed();
        System.out.println(sK.getAnimals());

    }

}
