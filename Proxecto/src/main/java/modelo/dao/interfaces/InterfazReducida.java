package modelo.dao.interfaces;

import java.util.List;

public interface InterfazReducida<T> {
    List<T> read();
    T findById(T t);
    T findByName(T t);
}
