package controller;

import controller.structures.Dictionary;
import controller.structures.circularLinkedList.CircularLinkedList;
import controller.structures.stock.Stock;
import model.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Benchmark<T> {
    CircularLinkedList<T> circularLinkedList;
    Stock<T> stock;

    public Benchmark() {
    }

    public static List<Integer> generateIntegers(int amount) {
        ArrayList<Integer> ints = new ArrayList<>();
        Random randInt = new Random();
        for (int i = 0; i < amount; i++) {
            ints.add(randInt.nextInt(100));
        }
        return ints;
    }

    public static List<Book> generateBooks(String filePath, int amount) throws IOException {
        if(amount > 10000 || amount <= 0) throw new IllegalArgumentException("THE AMOUNT OF BOOKS IS INVALID, CANNOT GENERATE BOOKS FOR AMOUNT: "+ amount);

        File file = new File(filePath);
        List<Book> books = new ArrayList<>();

        if (!file.canRead()) throw new IOException("Cannot read file " + file.getName());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;

            for(int i = 0; i < amount; i++) {
                line = br.readLine();
                String[] s = line.split(",");
                if (s.length != 3) throw new IllegalArgumentException("CANNOT CREATE BOOK WITH " + Arrays.toString(s) + " PARAMETERS");
                Book book = new Book(s[0].trim(), s[1].trim(), Integer.parseInt(s[2].trim()));
                books.add(book);
            }
        } catch (IOException e) {
            throw new IOException("Failed to read the file " + e.getMessage());
        }
        return books;
    }


    private Dictionary<T> loadCollection(Dictionary<T> dictionary, List<T> data) {
        for(int i = 0; i < data.size(); i++) {dictionary.insert(data.get(i));}
        return dictionary;
    }
    public String testInsert(Dictionary<T> dictionary, List<T> data) {
        long start = System.nanoTime(); //Time in nanoseconds

        System.out.println("STARTING TEST INSERT FOR: " + data.size() + " ELEMENTS");
        long end = System.nanoTime();
        return TimeFormatter.formatElapsedTime(end - start);
    }

    //Test the remove time for the desired collection dictionary, using data from the List data
    public String testLookUp(Dictionary<T> dictionary, List<T> data) {
        Dictionary<T> ds = loadCollection(dictionary, data); //Loads the collection before proceed with the lookUp test
        long start = System.nanoTime(); //Time in nanoseconds

        System.out.println("STARTING TEST LOOKUP FOR: " + data.size() + " ELEMENTS");
        for (int i = 0; i < data.size(); i++) {ds.lookUp(data.get(i));}

        long end = System.nanoTime();
        return TimeFormatter.formatElapsedTime(end - start);
    }

    //Test the remove time for the desired collection dictionary, using data from the list
    public String testRemove(Dictionary<T> dictionary, List<T> data) {
        Dictionary<T> ds = loadCollection(dictionary, data); //Loads the collection before proceed with the remove test
        long start = System.nanoTime();//Time in nanoseconds

        System.out.println("STARTING TEST REMOVE FOR: " + data.size() + " ELEMENTS");
        for (int i = 0; i < data.size(); i++) {ds.remove(data.get(i));}

        long end = System.nanoTime();
        return TimeFormatter.formatElapsedTime(end - start);
    }


}
