package controller;

import model.Book;

import java.io.IOException;
import java.util.List;

public class TestBenchmark {
    public static void main(String[] args) {
        try{
            List<Book> books= Benchmark.generateBooks("/home/augusto-henrique/Documents/estudos/BSI/2025_03/prog_III/tp2/src/resources/books.txt");
            System.out.println();
        }catch (IOException e){e.printStackTrace();}
    }
}
