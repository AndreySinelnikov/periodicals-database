package epam.lab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface CrudDao<T> {

    ResultSet get(Integer id) throws SQLException;

    ResultSet getAll() throws SQLException;

    ResultSet update(T object) throws SQLException;

    ResultSet create(T object) throws SQLException;

    Integer delete(Integer id) throws SQLException;
}
