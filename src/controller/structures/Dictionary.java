package controller.structures;

public interface Dictionary<T> {
    void insert(T value);
    T lookUp(int id);
    void remove(int id);
}
