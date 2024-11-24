package com.java.collections;

import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Basics {
    public static void main(String [] args) {
      list();
    }

    public static void list() {
        arrayList();
    }


    public static void arrayList() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Grapes");
        fruits.add("Mango");
        fruits.add("Pineapple");
        fruits.add("Banana");

        System.out.println(fruits);

        fruits.remove("Pineapple");
        System.out.println("Removed Pineapple: "+fruits);
        System.out.println("Is list contains Pineapple?? : "+ fruits.contains("Pineapple"));

        fruits.forEach(System.out::println);
        System.out.println("First element in fruits : " + fruits.get(0));
        fruits.add("Apple");
        System.out.println("It can accept duplicate values - added Apple again : " + fruits);

    }
}
