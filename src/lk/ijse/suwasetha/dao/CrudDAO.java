package lk.ijse.suwasetha.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T,ID>extends SuperDAO{
    public boolean save(T t) throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public boolean update(T t) throws SQLException, ClassNotFoundException;
    public T get(ID id) throws SQLException, ClassNotFoundException;
    public List<T> getAll() throws SQLException, ClassNotFoundException;
}
