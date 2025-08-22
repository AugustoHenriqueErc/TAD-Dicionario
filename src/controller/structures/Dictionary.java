package controller.structures;

public interface Dictionary<T> {
    void insert(T value);
    boolean lookUp(int id);
    boolean remove(int id);


}
