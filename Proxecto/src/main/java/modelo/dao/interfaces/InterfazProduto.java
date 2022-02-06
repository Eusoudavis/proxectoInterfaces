package modelo.dao.interfaces;

import java.util.List;

public interface InterfazProduto<T> {
    void create(T t);
    List<T> read();
    List<T> readProduto(T t);
    T findById(T t);
    void update(T t);
    void delete(T t);
}
