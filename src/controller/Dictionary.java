package controller;

public interface Dictionary {
    void insert(Object o);
    Object lookUp(int id);
    void remove(int id);
}
