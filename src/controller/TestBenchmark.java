package controller;

import controller.structures.circularLinkedList.CircularLinkedList;
import model.Book;

import java.io.IOException;
import java.util.List;

public class TestBenchmark {
    public static void main(String[] args) {
        CircularLinkedList<Book> booksCircularLinkedList = new CircularLinkedList<>();
        CircularLinkedList<Integer> integerCircularLinkedList = new CircularLinkedList<>();
        try{
            List<Book> books= Benchmark.generateBooks("/home/augusto-henrique/Documents/estudos/BSI/2025_03/prog_III/tp2/src/resources/books.txt",10000);
            System.out.println("TESTING BENCHMARK LOAD AND LOOKUP FOR BOOK DATATYPE");
            Benchmark<Book> bookBenchmark = new Benchmark<>();

            System.out.println("BENCHMARK TIME FOR LOOKUP IN 10000 BOOKS: " + bookBenchmark.testLookUp(booksCircularLinkedList, books));
            System.out.println("BENCHMARK TIME FOR INSERT IN 10000 BOOKS: " + bookBenchmark.testInsert(booksCircularLinkedList, books));
            System.out.println("BENCHMARK TIME FOR REMOVE IN 10000 BOOKS: " + bookBenchmark.testRemove(booksCircularLinkedList, books));

            List<Integer> ints = Benchmark.generateIntegers(10000);
            System.out.println("TESTING BENCHMARK INSERT, LOOKUP AND REMOVE FOR INTEGER DATATYPE");
            Benchmark<Integer> integerBenchmark = new Benchmark<>();

            System.out.println("BENCHMARK TIME FOR LOOKUP IN 10000 INTEGERS: " + integerBenchmark.testLookUp(integerCircularLinkedList, ints));
            System.out.println("BENCHMARK TIME FOR INSERT IN 10000 INTEGERS: " + integerBenchmark.testInsert(integerCircularLinkedList, ints));
            System.out.println("BENCHMARK TIME FOR REMOVE IN 10000 INTEGERS: " + integerBenchmark.testRemove(integerCircularLinkedList, ints));
        }catch (IOException e){e.printStackTrace();}


    }
}
