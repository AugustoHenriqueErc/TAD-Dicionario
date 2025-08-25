package controller;

import model.structures.Dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Benchmark {

    public Benchmark() {
    }

    public static List<Integer> generateIntegers(int amount) {
        int min = - amount;
        int max = amount;

        if (amount > (max - min + 1)) {throw new IllegalArgumentException("Amount is larger than the range of unique values available.");}

        List<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers, new Random());

        return new ArrayList<>(numbers.subList(0, amount));
    }


    private static Dictionary loadCollection(Dictionary dictionary, List<Integer> data) {
        for(int i = 0; i < data.size(); i++) {dictionary.insert(data.get(i));}
        return dictionary;
    }
    public static String testInsert(Dictionary dictionary, List<Integer> data) {
        long start = System.nanoTime(); //Time in nanoseconds

        System.out.println("STARTING TEST INSERT");
        long end = System.nanoTime();
        return TimeFormatter.formatElapsedTime(end - start);
    }

    //Test the remove time for the desired collection dictionary, using data from the List data
    public static String testLookUp(Dictionary dictionary, List<Integer> data) {
        //loadCollection(dictionary, data); //Loads the collection before proceed with the lookUp test
        long start = System.nanoTime(); //Time in nanoseconds

        System.out.println("STARTING TEST LOOKUP FOR");
        for (int i = 0; i < data.size(); i++) {dictionary.lookUp(data.get(i));}

        long end = System.nanoTime();
        return TimeFormatter.formatElapsedTime(end - start);
    }

    //Test the remove time for the desired collection dictionary, using data from the list
    public static String testRemove(Dictionary dictionary, List<Integer> data) {
        Dictionary dc = loadCollection(dictionary, data); //Loads the collection before proceed with the remove test
        long start = System.nanoTime();//Time in nanoseconds

        System.out.println("STARTING TEST REMOVE");
        for (int i = 0; i < data.size(); i++) {dc.remove(data.get(i));}

        long end = System.nanoTime();
        return TimeFormatter.formatElapsedTime(end - start);
    }


}
