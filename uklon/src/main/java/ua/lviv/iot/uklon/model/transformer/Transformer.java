package ua.lviv.iot.uklon.model.transformer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.manager.EntityManager;

public class Transformer<E, K> {

  private EntityManager<E, K> entityManager;

  public Transformer(Class<E> clazz) {
    this.entityManager = new EntityManager<E, K>(clazz);
  }

  public E fromResultSetToEntity(ResultSet resultSet) throws InstantiationException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
    E entity = null;
    entity = entityManager.getEntityClass().getConstructor().newInstance();
    for (Field field : entityManager.getEntityFields()) {
      if (field.isAnnotationPresent(Column.class)) {
        Column column = field.getAnnotation(Column.class);
        String name = column.name();
        field.setAccessible(true);
        Class<?> fieldType = field.getType();
        if (fieldType == String.class) {
          field.set(entity, resultSet.getString(name));
        } else if (fieldType == Integer.class) {
          field.set(entity, resultSet.getInt(name));
        } else if (fieldType == Date.class) {
          field.set(entity, resultSet.getDate(name));
        } else if (fieldType == BigDecimal.class) {
          field.set(entity, resultSet.getBigDecimal(name));
        } else if (fieldType == Float.class) {
          field.set(entity, resultSet.getFloat(name));
        }
      }
    }
    return entity;
  }

  public boolean setPreparedStatementWithType(int index, PreparedStatement ps, Object value) throws SQLException {
    Class<?> fieldType = value.getClass();
    if (fieldType == Integer.class) {
      ps.setInt(index, (Integer) value);
    } else if (fieldType == String.class) {
      ps.setString(index, (String) value);
    } else if (fieldType == Date.class) {
      ps.setDate(index, (Date) value);
    } else if (fieldType == BigDecimal.class) {
      ps.setBigDecimal(index, (BigDecimal) value);
    } else if (fieldType == Float.class) {
      ps.setFloat(index, (Float) value);
    } else {
      return false;
    }
    return true;
  }

  public int setValuesColumnsInPreparedStatement(int startFromIndex, PreparedStatement preparedStatement, E entity)
      throws IllegalArgumentException, IllegalAccessException, SQLException {
    int index = startFromIndex;
    for (Field field : entityManager.getColumnsForInput()) {
      field.setAccessible(true);
      setPreparedStatementWithType(index, preparedStatement, field.get(entity));
      index++;
    }
    int nextEmptyIndex = index;
    return nextEmptyIndex;
  }
}
