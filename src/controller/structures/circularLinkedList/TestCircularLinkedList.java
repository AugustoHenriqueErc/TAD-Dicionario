package controller.structures.circularLinkedList;

import model.Book;

public class TestCircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList<Book> list = new CircularLinkedList<>();

        // Fiction Books
        Book book1 = new Book("The Midnight Library", "13-08-2020", 304);
        Book book2 = new Book("Project Hail Mary", "04-05-2021", 476);
        Book book3 = new Book("The Seven Husbands of Evelyn Hugo", "13-06-2017", 389);
        Book book99 = new Book("The Alchemist", "01-01-1988", 208);

        // Teste inserções
        list.insert(book1);
        list.insert(book2);
        list.insert(book3);

        System.out.println("Lista após inserções: " + list);

        // Teste busca
        System.out.println("Procurando elemento 1: " + list.lookUp(book1));
        System.out.println("Procurando elemento 99: " + list.lookUp(book99));

        // Teste remoção
        System.out.println("Removendo book1: " + list.remove(book1));
        System.out.println("Lista:\n" + list);

        System.out.println("Removendo book2: " + list.remove(book2));
        System.out.println("Lista:\n" + list);

        System.out.println("Removendo book3: " + list.remove(book3));
        System.out.println("Lista:\n" + list);

        System.out.println("Tentando remover de lista vazia: " + list.remove(book1));
    }
}
