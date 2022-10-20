package org.example;


/*
* TODO
Описать класс CatStatistics со статическими методами:
+ ArrayList<Cat> sortByNameAscending(ArrayList<Cat> cats) — возвращает список котов, отсортировав по имени по возрастанию.
+ ArrayList<Cat> sortByWeightDescending(ArrayList<Cat> cats) — возвращает список котов, отсортировав по убыванию веса.
+ ArrayList<Cat> removeFirstAndLast (ArrayList<Cat> cats) — возвращает список котов кроме первого и последнего.
+ Cat findFirstNonAngryCat (ArrayList<Cat> cats) — возвращает первого не-сердитого кота в списке.
+ int getCommonWeight(ArrayList<Cat> cats, boolean onlyAngry) — возвращает суммарный вес всех котов (если параметр onlyAngry равен true, то только сердитых котов).
+ Map<String, List<Cat>> groupCatsByFirstLetter (ArrayList<Cat> cats) — возвращает список котов сгруппировав их по первой букве имени и отсортировав группировку по возрастанию.
*/


import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main( String[] args ) throws IncorrectCatWeightException {

        Cat<String> murka = new Cat<>("Мурка", 3);
        murka.setId("M0422");

        Cat<Long> barsik = new Cat<>("Барсик", 5);
        barsik.setId(666L);

        Cat murzik = new Cat("Мурзик", 7);

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(murzik);
        cats.add(barsik);
        cats.add(murka);

        Map <String, Cat> mappedCats = new HashMap<>();

        for (Cat cat : cats) mappedCats.put(cat.getName(), cat);

        System.out.println(mappedCats);
        System.out.println();

        System.out.println(mappedCats.get("Мурка"));
        System.out.println();

        for (String key : mappedCats.keySet()) {
            System.out.println(key);
            System.out.println(mappedCats.get(key));
        }

        Arithmetic action = Calculator.getAction(1);
        System.out.println(Calculator.doAction(20, 10, action));

        Arithmetic summation = (x, y) -> x + y;
        System.out.println(summation.getResult(30, 40));

        Arithmetic division = (x, y) -> {
            return y == 0 ? 0 : x / y;
        };
        System.out.println(division.getResult(3, 0));

        BinaryOperator<Integer> addition = (x, y) -> x + y;
        System.out.println(addition.apply(3, 4));

        Comparator<Cat> byWeight = (cat1, cat2) -> {
            return cat1.getWeight() - cat2.getWeight();
        };

        Comparator<Cat> byName = Comparator.comparing(Cat::getName);

        System.out.println(byWeight.compare(murka, murzik));
        System.out.println(byName.compare(murzik, barsik));

        System.out.println("Коты:");
        cats.stream().forEach(System.out::println);
        System.out.println("Лямбда коты:");
        cats.forEach(cat -> System.out.println(cat.getName().charAt(0)));

        ArrayList<Cat> newCats = Stream.of(murzik, barsik, murka).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(newCats.stream().anyMatch(cat -> cat.getWeight() > 5));

        System.out.println();
        System.out.println("Mapped cats");
        cats.stream()
                .filter(cat -> cat.getWeight() < 6)
                .map(Cat::getName)
//                .sorted((name1, name2) -> name2.compareTo(name1))
                .sorted(Comparator.reverseOrder())
//                .sorted(String::compareTo)
                .forEach(System.out::println);
        System.out.println();

        cats.stream()
                .sorted((cat1, cat2) -> cat1.getWeight() -  cat2.getWeight())
                .map(Cat::getName)
                .forEach(System.out::println);

        System.out.println();
        Cat fatCat;
        fatCat = cats.stream()
                .filter(cat -> cat.getWeight() > 7)
                .findFirst().orElse(new Cat("Колбас", 22));
        cats.add(fatCat);

        System.out.println(CatStatistics.sortByNameAscending(cats));
        System.out.println(CatStatistics.sortByWeightDescending(cats));
        System.out.println();

        System.out.println(cats);
        System.out.println(CatStatistics.removeFirstAndLast(cats));
        System.out.println();

        System.out.println(CatStatistics.findFirstNonAngryCat(cats));
        murka.setAngry(true);
        System.out.println(CatStatistics.getCommonWeight(cats, true));
        System.out.println(CatStatistics.groupCatsByFirstLetter(cats));

    }

}
