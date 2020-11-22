package ua.lviv.iot.uklon.model.service;

import java.sql.SQLException;
import java.util.List;

public interface Service<E, K> {
  List<E> findAll() throws SQLException;

  E findById(K id) throws SQLException;

  E create(E entity) throws SQLException;

  E update(K id, E entity) throws SQLException;

  E delete(K id) throws SQLException;
}