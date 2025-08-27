package model.structures.avlTree;

import model.structures.Dictionary;

public class AVLTree implements Dictionary {
    private Node root;

    private static class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    // Interface: insert
    @Override
    public void insert(int value) {
        root = insert(root, value);
    }

    // Interface: lookup
    @Override
    public boolean lookUp(int value) {
        return dfsSearch(root, value);
    }

    // Interface: remove
    @Override
    public boolean remove(int value) {
        if (!lookUp(value)) return false; // only remove if present
        root = remove(root, value);
        return true;
    }

    // DFS search helper
    private boolean dfsSearch(Node node, int key) {
        if (node == null) return false;
        if (node.key == key) return true;
        return dfsSearch(node.left, key) || dfsSearch(node.right, key);
    }

    // Insertion with balancing
    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // no duplicates

        updateHeight(node);
        return balance(node);
    }

    // Removal with balancing
    private Node remove(Node node, int key) {
        if (node == null) return null;

        if (key < node.key)
            node.left = remove(node.left, key);
        else if (key > node.key)
            node.right = remove(node.right, key);
        else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node minLargerNode = getMin(node.right);
                node.key = minLargerNode.key;
                node.right = remove(node.right, minLargerNode.key);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        return balance(node);
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private Node balance(Node node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.left) < 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1) {
            if (getBalance(node.right) > 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node getMin(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Debug printing
    public void printInOrder() {
        System.out.print("In-order: ");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.key + " ");
            printInOrder(node.right);
        }
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.key);
            printTree(node.left, prefix + (isTail ? "    " : "│   "), false);
            printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}
