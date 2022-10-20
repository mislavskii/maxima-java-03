package org.example;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatStatistics {

    public static ArrayList<Cat> sortByNameAscending(ArrayList<Cat> cats) {
        return cats.stream()
                .sorted(Comparator.comparing(Cat::getName))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Cat> sortByWeightDescending(ArrayList<Cat> cats) {
        return cats.stream()
                .sorted((cat1, cat2) -> cat2.getWeight() -  cat1.getWeight())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Cat> removeFirstAndLast (ArrayList<Cat> cats) {
        return cats.stream()
                .limit(cats.size() - 1)
                .skip(1)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Cat findFirstNonAngryCat (ArrayList<Cat> cats) {
        return cats.stream()
                .filter(cat -> !cat.isAngry())
                .findFirst().orElse(null );
    }

    public static int getCommonWeight(ArrayList<Cat> cats, boolean onlyAngry) {
        Stream<Cat> finalCats = onlyAngry ? cats.stream().filter(Cat::isAngry) : cats.stream();
        return finalCats.mapToInt(Cat::getWeight).sum();
    }

    public static Map<String, List<Cat>> groupCatsByFirstLetter (ArrayList<Cat> cats) {
//      возвращает список котов, сгруппировав их по первой букве имени и отсортировав группировку по возрастанию.
        Map <String, List<Cat>> groupedCats = cats.stream()
                .collect(Collectors.groupingBy(cat -> cat.getName().substring(0,1)));
        groupedCats.entrySet().forEach(entry -> entry.setValue(
                entry.getValue().stream()
                        .sorted(Comparator.comparing(Cat::getName))
                        .collect(Collectors.toList())));
        return groupedCats;
    }

}
