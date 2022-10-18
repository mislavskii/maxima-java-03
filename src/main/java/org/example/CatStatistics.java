package org.example;

import java.util.*;
import java.util.stream.Collectors;

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
        ArrayList<Cat> ourCats = cats;
        if (onlyAngry) {
            ourCats = ourCats.stream()
                    .filter(Cat::isAngry)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return ourCats.stream().mapToInt(Cat::getWeight).sum();
    }

    public static Map<String, List<Cat>> groupCatsByFirstLetter (ArrayList<Cat> cats) {
//      возвращает список котов, сгруппировав их по первой букве имени и отсортировав группировку по возрастанию.
        Map <String, List<Cat>> groupedCats = new HashMap<>();
        for (Cat cat : cats) {
            String initial = String.valueOf(cat.getName().charAt(0));
            if (!groupedCats.containsKey(initial)) {
                groupedCats.put(initial, cats.stream()
                        .filter(c -> String.valueOf(c.getName().charAt(0)).equals(initial))
                        .sorted(Comparator.comparing(Cat::getName))
                        .collect(Collectors.toList()));
            }
        }
        return groupedCats;
    }

}
