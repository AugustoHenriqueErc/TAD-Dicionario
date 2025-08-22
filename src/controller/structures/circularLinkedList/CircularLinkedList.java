package controller.structures.circularLinkedList;

import controller.structures.Dictionary;
import model.Book;
public class CircularLinkedList<T> implements Dictionary<T> {
    private Cell<T> head;
    private Cell<T> tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void insert(T value) {
        Cell<T> cell = new Cell<T>(value);
        if (head == null) { // lista vazia
            head = cell;
            tail = cell;
            tail.setNext(head);
        } else {
            cell.setNext(head);
            head = cell;
            tail.setNext(head);
        }
    }

    @Override
    public T lookUp(int id) {
        if (head == null) return null;
        Cell<T> aux = head;
        do {
            if (aux.getValue().equals(value)) {
                return aux.getValue();
            }
            aux = aux.getNext();
        } while (aux != head);
        return false;
    }

    // Remover elemento
    public boolean remove(T value) {
        if (head == null) return false;

        Cell aux = head;
        Cell prev = tail;

        do {
            if (aux.getValue().equals(value)) {
                if (aux == head) { // remover do início
                    head = head.getNext();
                    tail.setNext(head);
                } else if (aux == tail) { // remover do fim
                    tail = prev;
                    tail.setNext(head);
                } else { // remover no meio
                    prev.setNext(aux.getNext());
                }
                // caso a lista fique vazia
                if (head == aux && head == tail) {
                    head = null;
                    tail = null;
                }
                return true;
            }
            prev = aux;
            aux = aux.getNext();
        } while (aux != head);

        return false;
    }

    // Representação em String
    @Override
    public String toString() {
        if (head == null) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Cell aux = head;
        do {
            sb.append(aux.getValue());
            aux = aux.getNext();
            if (aux != head) sb.append(", ");
        } while (aux != head);
        sb.append("]");
        return sb.toString();
    }
}
