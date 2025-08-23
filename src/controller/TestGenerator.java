package controller;

import controller.structures.circularLinkedList.CircularLinkedList;
import model.Book;

import java.io.IOException;
import java.util.List;

public class TestGenerator {
    public static void generateIntegerTests(int amount) {
        CircularLinkedList<Integer> integerCircularLinkedList = new CircularLinkedList<>();
        List<Integer> ints = Benchmark.generateIntegers(amount);
        System.out.println("TESTING BENCHMARK INSERT, LOOKUP AND REMOVE FOR INTEGER DATATYPE USING CIRCULARLINKEDLIST DATASTRUCTURE");
        Benchmark<Integer> integerBenchmark = new Benchmark<>();

        System.out.println("BENCHMARK TIME FOR INSERT IN " + amount + " INTEGERS: " + integerBenchmark.testInsert(integerCircularLinkedList, ints));
        System.out.println("BENCHMARK TIME FOR LOOKUP IN " + amount + " INTEGERS: " + integerBenchmark.testLookUp(integerCircularLinkedList, ints));
        System.out.println("BENCHMARK TIME FOR REMOVE IN " + amount + " INTEGERS: " + integerBenchmark.testRemove(integerCircularLinkedList, ints));
    }
    public static void generateBookTests(int amount){
        try {
            CircularLinkedList<Book> bookCircularLinkedList = new CircularLinkedList<>();
            List<Book> books= Benchmark.generateBooks("/home/augusto-henrique/Documents/estudos/BSI/2025_03/prog_III/tp2/src/resources/books.txt",10000);
            System.out.println("TESTING BENCHMARK LOAD AND LOOKUP FOR BOOK DATATYPE CIRCULARLINKEDLIST DATASTRUCTURE");
            Benchmark<Book> bookBenchmark = new Benchmark<>();

            System.out.println("BENCHMARK TIME FOR INSERT IN " + amount + " BOOKS: " + bookBenchmark.testInsert(bookCircularLinkedList, books));
            System.out.println("BENCHMARK TIME FOR LOOKUP IN " + amount + " BOOKS: " + bookBenchmark.testLookUp(bookCircularLinkedList, books));
            System.out.println("BENCHMARK TIME FOR REMOVE IN " + amount + " BOOKS: " + bookBenchmark.testRemove(bookCircularLinkedList, books));

        }catch (IOException e) {e.printStackTrace();}
    }


}
