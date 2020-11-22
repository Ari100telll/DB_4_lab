package ua.lviv.iot.uklon.model.dataaccess.implementation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.uklon.model.annotation.Table;
import ua.lviv.iot.uklon.model.connectors.ConnectionManager;
import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.manager.EntityManager;
import ua.lviv.iot.uklon.model.transformer.Transformer;

public abstract class AbstractDataAccess<E, K> implements DataAccess<E, K> {

  private static final String FIND_ALL_FORMAT = "SELECT * FROM %s";
  private static final String FIND_BY_FORMAT = "SELECT * FROM %s WHERE %s=?";
  private static final String INSERT_FORMAT = "INSERT %s (%s) VALUES (%s)";
  private static final String UPDATE_FORMAT = "UPDATE %s SET %s WHERE %s=?";
  private static final String DELETE_FORMAT = "DELETE FROM %s WHERE %s=?";

  private static final String ERROR_EXEPTION_FORMAT = "[Error] Exeption while %s";
  private static final String ERROR_MESSAGE_FORMAT = "[Error] Message: %s";

  private Class<E> clazz;
  private Transformer<E, K> entityTranformer;
  private EntityManager<E, K> entityManager;

  public AbstractDataAccess(Class<E> clazz) {
    this.clazz = clazz;
    this.entityManager = new EntityManager<E, K>(clazz);
    this.entityTranformer = new Transformer<E, K>(clazz);
  }

  @Override
  public List<E> findAll() throws SQLException {

    List<E> entityList = new LinkedList<E>();

    if (clazz.isAnnotationPresent(Table.class)) {
      try {
        Connection connection = ConnectionManager.getConnection();
        String tableName = entityManager.getTableName();
        String sql = String.format(FIND_ALL_FORMAT, tableName);
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
          try (ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
              entityList.add(entityTranformer.fromResultSetToEntity(resultSet));
            }
          } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
              | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            System.out.println(String.format(ERROR_EXEPTION_FORMAT, "transforming data into objects"));
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
          }
        }
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }
    }

    return entityList;

  }

  @Override
  public E findById(K id) throws SQLException {

    String tableName = entityManager.getTableName();
    String primaryKeyName = entityManager.getPrymaryKeyName();

    List<E> entities = findByField(tableName, primaryKeyName, id);
    if (entities.size() > 0) {
      return entities.get(0);
    } else {
      return null;
    }
  }

  private List<E> findByField(String tableName, String fildName, Object fieldValue) throws SQLException {

    List<E> entityList = new LinkedList<E>();

    if (clazz.isAnnotationPresent(Table.class)) {
      try {

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(FIND_BY_FORMAT, tableName, fildName);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

          boolean valueSetFlag = entityTranformer.setPreparedStatementWithType(1, preparedStatement, fieldValue);
          if (!valueSetFlag) {
            return null;
          }

          try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
              entityList.add(entityTranformer.fromResultSetToEntity(resultSet));
            }
          } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
              | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            System.out.println(String.format(ERROR_EXEPTION_FORMAT, "transforming data into objects"));
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
          }
        }
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }
    }

    return entityList;
  }

  @Override
  public int create(E entity) throws SQLException {

    if (clazz.isAnnotationPresent(Table.class)) {

      try {

        String tableName = entityManager.getTableName();
        String columnsNamesString = entityManager.generateColumnsNamesString();
        String columnsParameters = entityManager.generateColumnsParametersString();

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(INSERT_FORMAT, tableName, columnsNamesString, columnsParameters);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
          entityTranformer.setValuesColumnsInPreparedStatement(1, preparedStatement, entity);
          return preparedStatement.executeUpdate();
        } catch (IllegalArgumentException | IllegalAccessException e) {
          System.out.println(String.format(ERROR_EXEPTION_FORMAT, "preparing SQL query for INSERT"));
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }

    }
    return 0;
  }

  @Override
  public int update(E entity) throws SQLException {

    if (clazz.isAnnotationPresent(Table.class)) {

      try {

        String tableName = entityManager.getTableName();
        String updateColumnsString = entityManager.generateUpdateColumnsString();
        String primaryKeyName = entityManager.getPrymaryKeyName();
        K primaryKeyValue = entityManager.getPrimaryKeyValue(entity);

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(UPDATE_FORMAT, tableName, updateColumnsString, primaryKeyName);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
          int nextEmptyIndex;
          nextEmptyIndex = entityTranformer.setValuesColumnsInPreparedStatement(1, preparedStatement, entity);
          boolean isValueSet = entityTranformer.setPreparedStatementWithType(nextEmptyIndex, preparedStatement, primaryKeyValue);
          if (isValueSet == false) {
            return 0;
          }
          return preparedStatement.executeUpdate();
        }
      } catch (IllegalArgumentException | IllegalAccessException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "preparing SQL query for UPDATE"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }

    }

    return 0;
  }

  @Override
  public int delete(K id) throws SQLException {

    if (clazz.isAnnotationPresent(Table.class)) {

      try {

        String tableName = entityManager.getTableName();
        String primaryKeyName = entityManager.getPrymaryKeyName();

        Connection connection = ConnectionManager.getConnection();
        String sql = String.format(DELETE_FORMAT, tableName, primaryKeyName);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
          boolean isValueSet = entityTranformer.setPreparedStatementWithType(1, preparedStatement, id);
          if (isValueSet == false) {
            return 0;
          }
          return preparedStatement.executeUpdate();
        }
      } catch (IOException e) {
        System.out.println(String.format(ERROR_EXEPTION_FORMAT, "getting credentials to database"));
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }

    }

    return 0;
  }
}
