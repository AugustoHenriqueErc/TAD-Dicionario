package model.structures.circularLinkedList;

public class Cell{
    int value;
    Cell next;

    public Cell(int value){
        this.value = value;
        this.next = null;
    }

    public void setValue(int value) {this.value = value;}

    public void setNext(Cell next) {this.next = next;}

    public Cell getNext(){return next;}

    public int getValue() {return value;}
}
