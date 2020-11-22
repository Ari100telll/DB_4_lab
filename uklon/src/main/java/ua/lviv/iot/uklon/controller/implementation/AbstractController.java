package ua.lviv.iot.uklon.controller.implementation;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.service.Service;

public abstract class AbstractController<E, K> implements Controller<E, K> {

  private Service<E, K> service;

  public AbstractController(Service<E, K> service) {
    this.service = service;
  }

  @Override
  public List<E> findAll() throws SQLException {
    return service.findAll();
  }

  @Override
  public E findById(K id) throws SQLException {
    return service.findById(id);
  }

  @Override
  public E create(E entity) throws SQLException {
    return service.create(entity);
  }

  @Override
  public E update(K id, E entity) throws SQLException {
    return service.update(id, entity);
  }

  @Override
  public E delete(K id) throws SQLException {
    return service.delete(id);
  }

}
