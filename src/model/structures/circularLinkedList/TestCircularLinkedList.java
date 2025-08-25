package model.structures.circularLinkedList;

public class TestCircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList<Book> list = new CircularLinkedList<>();

        // Fiction Books
        int n1 = 0;
        int n2 = 1;
        int n3 = 2;
        int n99 = 99;


        // Teste inserções
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);

        System.out.println("Lista após inserções: " + list);

        // Teste busca
        System.out.println("Procurando elemento 1: " + list.lookUp(n1));
        System.out.println("Procurando elemento 99: " + list.lookUp(n99));

        // Teste remoção
        System.out.println("Removendo book1: " + list.remove(n1));
        System.out.println("Lista:\n" + list);

        System.out.println("Removendo book2: " + list.remove(n2));
        System.out.println("Lista:\n" + list);

        System.out.println("Removendo book3: " + list.remove(n3));
        System.out.println("Lista:\n" + list);

        System.out.println("Tentando remover de lista vazia: " + list.remove(n1));
    }
}
