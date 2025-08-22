package controller.structures.circularLinkedList;

import model.Book;

public class TestCircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        // Fiction Books
        Book book1 = new Book("The Midnight Library", "2020-08-13", 304);
        Book book2 = new Book("Project Hail Mary", "2021-05-04", 476);
        Book book3 = new Book("The Seven Husbands of Evelyn Hugo", "2017-06-13", 389);


        // Teste inserções
        list.insertEnd(book1);
        list.insertEnd(book2);
        list.insertEnd(book3);

        System.out.println("Lista após inserções: " + list);

        // Teste busca
        System.out.println("Procurando elemento 5: " + list.search(5));
        System.out.println("Procurando elemento 99: " + list.search(99));

        // Teste remoção
        System.out.println("Removendo 5: " + list.remove(5));
        System.out.println("Lista: " + list);

        System.out.println("Removendo 20: " + list.remove(20));
        System.out.println("Lista: " + list);

        System.out.println("Removendo 10: " + list.remove(10));
        System.out.println("Lista: " + list);

        System.out.println("Tentando remover de lista vazia: " + list.remove(1));
    }
}
