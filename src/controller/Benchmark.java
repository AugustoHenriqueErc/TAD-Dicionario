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
    public Benchmark(){}

    public static List<Integer> generateIntegers(int n){
        ArrayList<Integer> ints = new ArrayList<>();
        Random randInt = new Random();
        for(int i = 0; i < n; i++){ints.add(randInt.nextInt(100));}
        return ints;
    }

    public static List<Book> generateBooks(String filePath) throws IOException {
        File file = new File(filePath);
        List<Book> books = new ArrayList<>();

        if (!file.canRead()) throw new IOException("Cannot read file " + file.getName());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                if(s.length != 3) throw new IllegalArgumentException("CANNOT CREATE BOOK WITH "+ Arrays.toString(s) +" PARAMETERS");
                Book book = new Book(s[0].trim(), s[1].trim(), Integer.parseInt(s[2].trim()));
                books.add(book);
                System.out.println("BOOK: " + line + " CREATED WITH SUCESS");
            }
        } catch (IOException e) {
            throw new IOException("Failed to read the file " + e.getMessage());
        }
        return books;
    }


private Dictionary<T> loadCollection(Dictionary<T> dictionary, List<T> data){
    System.out.print("INSERINDOD DADOS NA COLEÇÃO");
    for(int i = 0; i < data.size(); i++) {dictionary.insert(data.get(i));}
    return dictionary;
}

public long testLookUp(Dictionary<T> dictionary, List<T> data) {
    Dictionary<T> ds = loadCollection(dictionary, data);
    long start = System.nanoTime();
    System.out.println("COMEÇANDO TEST LOOKUP");
    for(int i = 0; i < data.size(); i++) {
        System.out.println(ds.lookUp(data.get(i)));}
    long end = System.nanoTime();
    return end - start;
}

public long testRemove(Dictionary<T> dictionary, List<T> data) {
    Dictionary<T> ds = loadCollection(dictionary, data);
    long start = System.nanoTime();
    System.out.println("COMEÇANDO TEST REMOVE");
    for(int i = 0; i < data.size(); i++) {
        System.out.println(ds.remove(data.get(i)));}
    long end = System.nanoTime();
    return end - start;
}


}
