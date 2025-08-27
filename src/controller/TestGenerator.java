package controller;

import model.structures.avlTree.AVLTree;
import model.structures.circularLinkedList.CircularLinkedList;
import model.structures.tree.BinaryTree;

import java.util.List;

public class TestGenerator {
    public static void generateTests(int amount) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        BinaryTree tree = new BinaryTree();
        AVLTree avlTree = new AVLTree();
        List<Integer> ints = Benchmark.generateIntegers(amount);

        System.out.println("TESTING BENCHMARK INSERT, LOOKUP AND REMOVE FOR INTEGER DATATYPE USING CIRCULARLINKEDLIST DATA STRUCTURE");
        System.out.println("BENCHMARK TIME FOR INSERT IN " + amount + " INTEGERS: " + Benchmark.testInsert(circularLinkedList, ints));
        System.out.println("BENCHMARK TIME FOR LOOKUP IN " + amount + " INTEGERS: " + Benchmark.testLookUp(circularLinkedList, ints));
        System.out.println("BENCHMARK TIME FOR REMOVE IN " + amount + " INTEGERS: " + Benchmark.testRemove(circularLinkedList, ints));

        System.out.println("TESTING BENCHMARK INSERT, LOOKUP AND REMOVE FOR INTEGER DATATYPE USING BINARYTREE DATA STRUCTURE");
        System.out.println("BENCHMARK TIME FOR INSERT IN " + amount + " INTEGERS: " + Benchmark.testInsert(tree, ints));
        System.out.println("BENCHMARK TIME FOR LOOKUP IN " + amount + " INTEGERS: " + Benchmark.testLookUp(tree, ints));
        System.out.println("BENCHMARK TIME FOR REMOVE IN " + amount + " INTEGERS: " + Benchmark.testRemove(tree, ints));

        System.out.println("TESTING BENCHMARK INSERT, LOOKUP AND REMOVE FOR INTEGER DATATYPE USING AVLTREE DATA STRUCTURE");
        System.out.println("BENCHMARK TIME FOR INSERT IN " + amount + " INTEGERS: " + Benchmark.testInsert(avlTree, ints));
        System.out.println("BENCHMARK TIME FOR LOOKUP IN " + amount + " INTEGERS: " + Benchmark.testLookUp(avlTree, ints));
        System.out.println("BENCHMARK TIME FOR REMOVE IN " + amount + " INTEGERS: " + Benchmark.testRemove(avlTree, ints));

        System.out.println("TESTE FINALIZADO");
    }
}
