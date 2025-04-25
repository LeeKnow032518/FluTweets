package ru.ibs.flutweets.ui;

import java.util.*;
import java.util.stream.Collectors;

public class Printer {
    public static void printStatistic(Map<String, String> data){
        Map<String, Integer> statistics = data.values().stream()
                .collect(Collectors.toMap(s -> s, i -> 1, (i1, i2) -> i1 + i2));
        statistics.keySet().stream().sorted().forEach(s -> System.out.println(s + "\t" +statistics.get(s)));
    }
}
