package model.structures.circularLinkedList;

import model.structures.Dictionary;

public class CircularLinkedList implements Dictionary {
    private Cell head;
    private Cell tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }
    private boolean isEmpty(){return head == null;}

    @Override
    public void insert(int value) {
        Cell cell = new Cell(value);
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
    public boolean lookUp(int value) {
        if (isEmpty()) return false;
        Cell aux = head;
        do {
            if (aux.getValue() == value) {return true;}
            aux = aux.getNext();
        } while (aux != head);
        return false;
    }

    @Override
    public boolean remove(int value) {
        if (isEmpty()) return false;

        Cell current = head;
        Cell previous = tail;

        do {
            if (current.getValue() == value) {
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
        StringBuilder sb = new StringBuilder("\n");
        Cell aux = head;
        do {
            sb.append(aux.getValue()).append("\n");
            aux = aux.getNext();
        } while (aux != head);
        return sb.toString();
    }
}
