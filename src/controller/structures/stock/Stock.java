package controller.structures.stock;

import controller.structures.Cell;
import controller.structures.Dictionary;

public class Stock<T> {
    Cell<T> top;
    int size;
    public Stock() {
        top = null;
        size = 0;
    }
    private boolean isEmpty(){
        if(top == null) return true;
        else return false;
    }
    public void insert(T value){
        Cell<T> cell = new Cell<>(value);
        cell.setNext(top);
        top = cell;
    }
    public void remove(int id){
        Cell<T> aux = top;
        for(int i = 0; i < id; i++) {
            top = top.getNext();
            aux.setNext(null);
        }
    }
    public boolean lookUp(int id){
        Cell<T> aux = top;
        for(int i = 0; i < id; i++) {
            top = top.getNext();
        }
        if(aux == null) return false;
        else return true;
    }

    @Override
    public String toString(){
        Cell<T> aux = top;
        StringBuilder sb = new StringBuilder();
        sb.append("Stock {");
        do{
            sb.append(aux).append(", ");
            aux = aux.getNext();
        }while (aux.getNext() != null);
        sb.append(aux).append("}");
        return sb.toString();
    }
}
