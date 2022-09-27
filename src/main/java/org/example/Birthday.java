package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Birthday {

    public static int getAge(int year, int month, int date) {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, Month.of(month), date);
        return (int) ChronoUnit.DAYS.between(birthDate, today);
    }

    public static LocalDate nextBirthday(int year, int month, int date) {
        int ageInDays = getAge(year, month, date);
        int daysToKday = 1000 - ageInDays % 1000;
        return LocalDate.now().plus(daysToKday, ChronoUnit.DAYS);
    }

}
