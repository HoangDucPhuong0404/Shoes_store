package service;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService <T> {
    List<T> findAll();

    T findById (int id);

    void save (T t);

    void insert(T t);
    boolean productExist(int id);




    boolean delete(int id) throws SQLException;

    boolean update(T t) throws SQLException;
}
