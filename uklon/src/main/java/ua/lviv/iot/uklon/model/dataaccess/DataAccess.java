package ua.lviv.iot.uklon.model.dataaccess;

import java.sql.SQLException;
import java.util.List;

public interface DataAccess<E, K>{
  
  List<E> findAll() throws SQLException;
  
  E findById(K id) throws SQLException;
  
  int create(E entity) throws SQLException;

  int update(E entity) throws SQLException;

  int delete(K id) throws SQLException;
}
  
