package controller.structures.circularLinkedList;

import controller.structures.Cell;
import controller.structures.Dictionary;

public class CircularLinkedList<T> implements Dictionary<T> {
    private Cell<T> head;
    private Cell<T> tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }
    private boolean isEmpty(){return head == null;}

    @Override
    public void insert(T value) {
        Cell<T> cell = new Cell<>(value);
        if (isEmpty()) { // lista vazia
            head = cell;
            tail = cell;
            tail.setNext(head);
        } else {
            tail.setNext(cell);
            cell.setNext(head);
            tail = cell;
        }
    }

    @Override
    public boolean lookUp(T value) {
        if (isEmpty()) return false;
        Cell<T> aux = head;
        do {
            if (aux.getValue().equals(value)) {
                return true;
            }
            aux = aux.getNext();
        } while (aux != head);
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (isEmpty()) return false;

        Cell<T> current = head;
        Cell<T> previous = tail;

        do {
            if (current.getValue().equals(value)) {
                if (current == head) {
                    if (head == tail) { // only one element
                        head = null;
                        tail = null;
                    } else {
                        head = head.getNext();
                        tail.setNext(head);
                    }
                } else if (current == tail) {
                    tail = previous;
                    tail.setNext(head);
                } else {
                    previous.setNext(current.getNext());
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        } while (current != head);

        return false; // value not found
    }

    // Representação em String
    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        Cell<T> aux = head;
        do {
            sb.append(aux.getValue()).append("\n");
            aux = aux.getNext();
        } while (aux != head);
        return sb.toString();
    }
}
