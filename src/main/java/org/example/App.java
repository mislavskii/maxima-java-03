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
Описать фабрику котов CatFactory со статическим методом Cat createCat(String name, int weight).
Этот метод будет пытаться создать кота, если вес указан корректный, то будет создан дружелюбный кот с указанным именем и весом.
Если вес указан неверно, будет создан сердитый кот весом 5 кг.
 */

public class App {
    public static void main( String[] args ) throws Exception {


        try {
            Cat cat = new Cat("ThungNgern", -1, false);
        } catch (IncorrectCatWeightException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
