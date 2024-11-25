package com.java.functionalprogramming;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Orange", "Grapes");
        //printer(fruits);
        printerWithFunctionalProg(fruits);


        List<Integer> numbers = List.of(5, 6, 7, 9, 8, 3, 2, 1, 4, 9);
        //numbers.stream().forEach(System.out::print);
        System.out.println("--------even Numbers--------");
        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
        System.out.println("--------Odd Numbers--------");
        numbers.stream()
                .filter(num -> num % 2 != 0)
                .forEach(System.out::println);
        System.out.println("--------Sum of Numbers--------");
        int res = numbers.stream().reduce(0,
                Integer::sum);
        System.out.println("sum: " + res);
        System.out.println("--------Sum of Odd Numbers--------");
        int oddSum = numbers.stream().filter(num -> num % 2 != 0).reduce(0,
                Integer::sum);
        System.out.println("Odd Sum: " + oddSum);

        //sorted(), distinct(), filter(), map()
        numbers.stream().distinct().sorted().forEach(System.out::println);

        numbers.stream()
                .distinct()
                .sorted()
                .map(e -> e * e)
                .forEach(e -> System.out.println("Squares of each element : " + e));

        Stream<Integer> num = IntStream.range(1,11).boxed();
        num.map(e -> e * e).forEach(System.out::println);

        Stream.of("Apple", "Banana", "Grapes", "Orange")
                .map(e -> e.toLowerCase(Locale.ROOT))
                .forEach(System.out::println);
        Stream.of("Apple", "Banana", "Grapes", "Orange")
                .map(String::length)
                .forEach(System.out::println);
        System.out.println(IntStream.range(1,11).reduce(Integer::sum));

        //terminal -> max(), reduce(), min(), toList(),
        Integer max = Stream.of(1, 3, 54, 65, 76, 42, 94, 21, 0)
                .max(Integer::compare).get();
        System.out.println(max);

        Integer min = Stream.of(1, 3, 54, 65, 76, 42, 94, 21)
                .min(Integer::compare).get();
        System.out.println(min);

        List<Integer> integers = Stream.of(1, 3, 54, 65, 76, 42, 94, 21)
                .filter(e -> e % 2 != 0).toList();
        System.out.println(integers);

        List<Integer> evenIntegers = Stream.of(1, 3, 54, 65, 76, 42, 94, 21)
                .filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(evenIntegers);

        List<Integer> squareIntegers = IntStream.range(1,11).boxed()
                .map(e -> e * e).collect(Collectors.toList());
        System.out.println(squareIntegers);
    }

    public static void printer(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void printerWithFunctionalProg(List<String> list) {
        list.stream().forEach(
                System.out::println
        );
    }
}
