package controller;

import model.structures.circularLinkedList.CircularLinkedList;
import model.structures.tree.BinaryTree;

import java.util.List;

public class TestBenchmark {
    public static void main(String[] args) {
        CircularLinkedList integerCircularLinkedList = new CircularLinkedList();
        BinaryTree tree = new BinaryTree();
        int amount = 1000000;
        List<Integer> ints = Benchmark.generateIntegers(amount);
        System.out.println("TESTING BENCHMARK INSERT, LOOKUP AND REMOVE FOR CIRCULARLINKEDLIST DATA STRUCTURE");


        System.out.println("BENCHMARK TIME FOR INSERT IN "+ amount +" INTEGERS: " + Benchmark.testInsert(integerCircularLinkedList, ints));
        System.out.println("BENCHMARK TIME FOR LOOKUP IN "+ amount +" INTEGERS: " + Benchmark.testLookUp(integerCircularLinkedList, ints));
        System.out.println("BENCHMARK TIME FOR REMOVE IN "+ amount +" INTEGERS: " + Benchmark.testRemove(integerCircularLinkedList, ints));

        System.out.println("TESTING BENCHMARK INSERT, LOOKUP AND REMOVE FOR BINARYTREE DATA STRUCTURE");

        System.out.println("BENCHMARK TIME FOR INSERT IN "+ amount +" INTEGERS: " + Benchmark.testInsert(tree, ints));
        System.out.println("BENCHMARK TIME FOR LOOKUP IN "+ amount +" INTEGERS: " + Benchmark.testLookUp(tree, ints));
        System.out.println("BENCHMARK TIME FOR REMOVE IN "+ amount +" INTEGERS: " + Benchmark.testRemove(tree, ints));

    }
}
