package Interface;

import POJO.Product;

import java.util.List;

public interface Generic<T> {

    boolean add(T p);
    T get(int id);
    List<T> getAll();
    boolean remove(int Id);
    boolean update(T p);
}
