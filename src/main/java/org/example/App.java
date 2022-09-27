package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/*
TODO:
 Описать класс Birthday c двумя статическими методами:
 int getAge(int year, int month, int date) — вернет возраст в днях
 LocalDate nextBirthday(int year, int month, int date) — вернет дату следующего дня рождения в 1000 дней.
 */
public class App {
    public static void main( String[] args ) {

        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1971, Month.of(11), 17);
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate kDay = today.plus(1000-577, ChronoUnit.DAYS);

        System.out.println("Hello Greater Sobaki! Today is " + today);
        System.out.println("My birth date is " + birthDate);
        System.out.println("Tomorrow will be " + tomorrow);
        System.out.println("My age in days is " + Birthday.getAge(1971, 11, 17));
        System.out.println("My next kDay magically is " + Birthday.nextBirthday(1971, 11, 17));
        System.out.println("And manually it is " + kDay);

    }
}
