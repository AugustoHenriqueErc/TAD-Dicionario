package stock;

public class Stock<T> {
    Cell<T> top;
    int size;
    public Stock()
    {
        top = null;
        size = 0;
    }
    private boolean isEmpty(){
        if(top == null) return true;
        else return false;
    }
    public void stack(T value){
        Cell<T> cell = new Cell<>(value);
        cell.setNext(top);
        top = cell;
    }
    public Cell<T> unstack(){
        Cell<T> aux = top;
        top = top.getNext();
        aux.setNext(null);
        return aux;
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
