package modelo.dao.interfaces;

import java.util.List;

public interface Interfaz<T> {
    void create(T t);
    List<T> read();
    T findById(T t);
    boolean update(T t);
    void delete(T t);
}
