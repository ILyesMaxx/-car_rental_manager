package DbHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class CentralDao<T> {

    protected Connection connection = null;

    public CentralDao(Connection connection) {
        this.connection = connection;
    }
    public abstract boolean create(T obj) throws SQLException, ClassNotFoundException;
    public abstract boolean update(T obj) throws SQLException, ClassNotFoundException;
    public abstract boolean delete(int id) throws SQLException, ClassNotFoundException;
    public abstract T find(int id) throws SQLException, ClassNotFoundException;
    public abstract List<T> findAll() throws SQLException, ClassNotFoundException;
}
