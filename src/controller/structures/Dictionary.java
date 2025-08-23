package controller.structures;

public interface Dictionary<T> {
    void insert(T value);
    boolean lookUp(T value);
    boolean remove(T value);
}
