package com.java.collections;

import java.util.*;

public class Basics {
    public static void main(String[] args) {
        list();
        set();
//        queue();
        map();
    }

    public static void list() {
//        arrayList();
//        createLinkedList();
    }

    public static void set() {
//        hashSet();
    }

    private static void hashSet() {
        Set<String> car = new HashSet<>();
        car.add("BMW");
        car.add("Bentley");
        car.add("Audi");
        car.add("Mercedes");
        car.add("BMW");
        System.out.println(car);
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
        System.out.println("Removed Pineapple: " + fruits);
        System.out.println("Is list contains Pineapple?? : " + fruits.contains("Pineapple"));

        fruits.forEach(System.out::println);
        System.out.println("First element in fruits : " + fruits.get(0));

        fruits.add("Apple");
        System.out.println("It can accept duplicate values - added Apple again : " + fruits);

        fruits.set(0, "Plum");
        System.out.println(fruits);

        fruits.remove("Plum");
        System.out.println(fruits + " remove plum");

        List<String> subFruits = new ArrayList<>();
        subFruits.add("Orange");
        subFruits.add("Banana");

        fruits.removeAll(subFruits);
        System.out.println(fruits + " remove all");

        //fruits.clear();
        System.out.println(fruits + " clear fruits");

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ListIterator<String> listIterator = fruits.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        Collections.sort(fruits);
        System.out.println(fruits);

        Collections.reverse(fruits);
        System.out.println(fruits);

    }

    public static void createLinkedList() {
        LinkedList<String> cars = new LinkedList<>();
        //add()
        cars.add("BMW");
        cars.add("Bentley");
        cars.add("Audi");
        cars.add("Mercedes");
        System.out.println(cars);

        //add(2, element)
        cars.add(3, "Lamborghini");
        System.out.println(cars);

        //addFirst
        cars.addFirst("Ferrari");
        System.out.println(cars);

        //addLast
        cars.addLast("Bugatti");
        System.out.println(cars);


        //retrieve elements from linked list

        //getFirst elements
        //getLast elements
        //given index elements

        System.out.println(cars.get(5));
        System.out.println(cars.getFirst());
        System.out.println(cars.getLast());

        //remove elements from linked list

        //remove first
        //remove last
        //first occurrence
        //clear all

        cars.removeFirst();
        System.out.println(cars);

        cars.removeLast();
        System.out.println(cars);

        cars.add("BMW");
        System.out.println(cars);
        cars.removeFirstOccurrence("BMW");
        System.out.println(cars);
        cars.addFirst("BMW");
        System.out.println(cars);
        cars.removeLastOccurrence("BMW");
        System.out.println(cars);

        //cars.clear();
        //System.out.println(cars);

        System.out.println("Is BMW there : " + cars.contains("BMW"));
        System.out.println("What is index of Mercedes there : " + cars.indexOf("Mercedes"));
        cars.add("Mercedes");
        System.out.println(cars);
        System.out.println("What is last index of Mercedes there : " + cars.lastIndexOf("Mercedes"));
        Collections.sort(cars);
        System.out.println(cars);
    }

    public static void queue() {
        Queue<String> queue = new PriorityQueue<>(new sort());
        queue.offer("Chevy");
        System.out.println(queue.poll());
        System.out.println(queue);

        queue.addAll(List.of("Chevy", "Ferrari", "Bugatti", "Mercedes", "Audi", "Bmw"));
        do {
            System.out.println(queue.poll());
        } while (!queue.isEmpty());

    }

    public static void map() {
        Map<String, Integer> map = Map.of("A", 3, "B", 6, "Z", 2);
        System.out.println(map);

        Map<String, Integer> hashMap = new HashMap<>(map);
        hashMap.put("G", 7);
        System.out.println(hashMap);

        String str = "This is a great thing . " +
                "This thing has never happened before";
        str = str.replace('.', ' ');
        Map<Character, Integer> occurances = new HashMap<>();

        char[] chars = str.toCharArray();

        for (char character : chars) {
            occurances.merge(character, 1, Integer::sum);
        }

        System.out.println(occurances);

        Map<String, Integer> wordOccurance = new HashMap<>();
        String[] words = str.split(" ");
        for (String word : words) {
            wordOccurance.merge(word, 1, Integer::sum);
        }
        System.out.println(wordOccurance);
    }
}

class sort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
