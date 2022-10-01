package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/*
TODO:
+ Описать класс Cat (кот) со свойствами
+ name — имя, строка.
+ weight — вес, число int
+ isAngry — сердитость, boolean
+ Описать геттеры и сеттеры всех свойств.
+ Описать свой класс исключений — IncorrectCatWeightException и выбрасывать его при присваивании коту отрицательного веса.
+ Описать фабрику котов CatFactory со статическим методом Cat createCat(String name, int weight).
+ Этот метод будет пытаться создать кота, если вес указан корректный, то будет создан дружелюбный кот с указанным именем и весом.
+ Если вес указан неверно, будет создан сердитый кот весом 5 кг.
 */

public class App {
    public static void main( String[] args ) throws Exception {

        Cat cat = CatFactory.createCat("Bad", -1);
        System.out.println(cat.getName() + " cat");
        System.out.println("weight: " + cat.getWeight());
        System.out.println("angry: " + cat.isAngry());
        System.out.println();

        cat = CatFactory.createCat("Good", 4);
        System.out.println(cat.getName() + " cat");
        System.out.println("weight: " + cat.getWeight());
        System.out.println("angry: " + cat.isAngry());
        System.out.println();

    }
}
