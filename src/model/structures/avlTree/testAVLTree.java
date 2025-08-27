package model.structures.avlTree;

public class testAVLTree {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Inserindo valores
        int[] values = {30, 20, 40, 10, 25, 35, 50};
        for (int v : values) {
            tree.insert(v);
        }

        // Print da árvore
        System.out.println("Árvore:");
        tree.printTree();

        // Testes de busca em profundidade
        System.out.println("\nBuscando valores na árvore (DFS):");
        int[] testValues = {10, 25, 50, 99};
        for (int val : testValues) {
            boolean found = tree.lookUp(val);
            System.out.println("Valor " + val + (found ? " encontrado." : " não encontrado."));
        }
    }
}

