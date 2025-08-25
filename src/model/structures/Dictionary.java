package model.structures;

public interface Dictionary {
    void insert(int value);
    boolean lookUp(int value);
    boolean remove(int value);
}
