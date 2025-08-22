package controller;

import controller.structures.Dictionary;
import controller.structures.circularLinkedList.CircularLinkedList;
import controller.structures.stock.Stock;
import model.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Benchmark<T> {
     CircularLinkedList<T> circularLinkedList;
    Stock<T> stock;
    public Benchmark(){}

    public static List<Integer> generateIntegers(int n){
        ArrayList<Integer> ints = new ArrayList<>();


        return ints;
    }

    public static List<Book> generateBooks(File file, String filePath) {
        ArrayList<Book> books = new ArrayList<>();

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
            System.out.println(ds.lookUp(i));}
        long end = System.nanoTime();
        return end - start;
    }

    public long testRemove(Dictionary<T> dictionary, List<T> data) {
        Dictionary<T> ds = loadCollection(dictionary, data);
        long start = System.nanoTime();
        System.out.println("COMEÇANDO TEST REMOVE");
        for(int i = 0; i < data.size(); i++) {
            System.out.println(ds.remove(i));}
        long end = System.nanoTime();
        return end - start;
    }


}
