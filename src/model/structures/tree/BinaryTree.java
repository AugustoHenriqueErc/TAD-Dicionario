package model.structures.tree;

import model.structures.Dictionary;

public class BinaryTree implements Dictionary {

    private Leaf leaf;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree() {
        this.leaf = null;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(Leaf newLeaf) {
        this.leaf = newLeaf;
        this.left = null;
        this.right = null;
    }

    public boolean isEmpty() {
        return this.leaf == null;
    }

    @Override
    public void insert(int value) {
        Leaf newLeaf = new Leaf(value);
        if (this.isEmpty()) {
            this.leaf = newLeaf;
        } else {
            BinaryTree newTree = new BinaryTree(newLeaf);
            if (newLeaf.getValue() < this.leaf.getValue()) {
                if (this.left == null) {
                    this.left = newTree;
                } else {
                    this.left.insert(value);
                }
            } else if (newLeaf.getValue() > this.leaf.getValue()) {
                if (this.right == null) {
                    this.right = newTree;
                } else {
                    this.right.insert(value);
                }
            }
        }
    }

    public void inOrder() {
        if (!this.isEmpty()) {
            if (this.left != null) {
                this.left.inOrder();
            }
            System.out.print(this.leaf.getValue() + " ");
            if (this.right != null) {
                this.right.inOrder();
            }
        }
    }

    public void postOrder() {
        if (!this.isEmpty()) {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.print(this.leaf.getValue() + " ");
        }
    }

    public void preOrder() {
        if (!this.isEmpty()) {
            System.out.print(this.leaf.getValue() + " ");
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }
    }

    @Override
    public boolean lookUp(int value) {
        if (this.isEmpty()) {
            return false;
        }

        if (value == this.leaf.getValue()) {
            return true;
        } else if (value < this.leaf.getValue()) {
            return this.left != null && this.left.lookUp(value);
        } else {
            return this.right != null && this.right.lookUp(value);
        }
    }

    @Override
    public boolean remove(int value) {

        BinaryTree result = removeNode(this, value);

        // If root changed, copy it back
        if (result == null) {
            this.leaf = null;
            this.left = null;
            this.right = null;
        } else {
            this.leaf = result.leaf;
            this.left = result.left;
            this.right = result.right;
        }
        return true;
    }

    private BinaryTree removeNode(BinaryTree node, int value) {
        if (node == null) return null;

        if (value < node.leaf.getValue()) {
            node.left = removeNode(node.left, value);
        } else if (value > node.leaf.getValue()) {
            node.right = removeNode(node.right, value);
        } else {
            // Node found
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                BinaryTree successor = findMinimum(node.right);
                node.leaf = successor.leaf;
                node.right = removeNode(node.right, successor.leaf.getValue());
            }
        }
        return node;
    }

    private BinaryTree findMinimum(BinaryTree node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
