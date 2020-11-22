package ua.lviv.iot.uklon.model.service.implementation;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.service.Service;

public abstract class AbstractService<E, K> implements Service<E, K> {

  private DataAccess<E, K> dataAccess;

  public AbstractService(DataAccess<E, K> dataAccess) {
    this.dataAccess = dataAccess;
  }

  @Override
  public List<E> findAll() throws SQLException {
    List<E> Entities = dataAccess.findAll();
    if (Entities.size() > 0) {
      return Entities;
    } else {
      return null;
    }
  }
  
  @Override
  public E findById(K id) throws SQLException{
    
    return dataAccess.findById(id);
    
  }
  
  @Override
  public E create(E entity) throws SQLException {
    int newEntitiesCount = dataAccess.create(entity);
    if (newEntitiesCount > 0) {
      E newEntity = null;
      List<E> entities = findAll();
      newEntity = entities.get(entities.size() - 1);
      return newEntity;
    }
    return null;
  }
  
  @Override
  public E update(K id, E entity) throws SQLException {
    E oldEntity = findById(id);
    int updatedEntitiesCount = dataAccess.update(entity);
    if (updatedEntitiesCount > 0) {
      return oldEntity;
    }
    return null;
  }
  
  @Override
  public E delete(K id) throws SQLException {
    E oldEntity = findById(id);
    int deletedEntitiesCount = dataAccess.delete(id);
    if (deletedEntitiesCount > 0) {
      return oldEntity;
    }
    return null;
  }
}
