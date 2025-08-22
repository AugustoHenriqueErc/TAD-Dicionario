package controller.structures;

public class Cell<T>{
    T value;
    Cell<T> next;

    public Cell(T value){
        this.value = value;
        this.next = null;
    }

    public void setValue(T value) {this.value = value;}

    public void setNext(Cell<T> next) {this.next = next;}

    public Cell<T> getNext(){return next;}

    public T getValue() {return value;}
}
