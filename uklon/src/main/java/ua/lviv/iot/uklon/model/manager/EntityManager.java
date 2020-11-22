package ua.lviv.iot.uklon.model.manager;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.uklon.model.annotation.Table;
import ua.lviv.iot.uklon.model.annotation.PrimaryKey;
import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.annotation.InputIgnore;;

public class EntityManager<E, K> {

  private Class<E> clazz;
  private Field[] fields;

  public EntityManager(Class<E> clazz) {
    this.clazz = clazz;
    this.fields = clazz.getDeclaredFields();
  }

  public Class<E> getEntityClass() {
    return clazz;
  }

  public Field[] getEntityFields() {
    return fields.clone();
  }

  public String tableName() {
    Table table = clazz.getAnnotation(Table.class);
    String tableName = table.name();
    return tableName;
  }

  public String getPrymaryKeyName() {
    for (Field field : fields) {
      if (field.isAnnotationPresent(PrimaryKey.class)) {
        return field.getAnnotation(Column.class).name();
      }
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  public K getPrimaryKeyValue(E entity) throws IllegalArgumentException, IllegalAccessException {
    for (Field field : fields) {
      if (field.isAnnotationPresent(PrimaryKey.class)) {
        field.setAccessible(true);
        ;
        return (K) field.get(entity);
      }
    }
    return null;
  }

  public List<Field> getColumns() {
    List<Field> columns = new LinkedList<Field>();
    for (Field field : fields) {
      if (field.isAnnotationPresent(Column.class)) {
        columns.add(field);
      }
    }
    return columns;
  }

  public List<Field> getColumnsForInput() {
    List<Field> inputColumns = new LinkedList<Field>();
    List<Field> columns = getColumns();
    for (Field field : columns) {
      if (!field.isAnnotationPresent(PrimaryKey.class) && !field.isAnnotationPresent(InputIgnore.class)) {
        inputColumns.add(field);
      }
    }
    return inputColumns;
  }
  
  public List<String> getColumnsNamesForInput() {
    List<String> columnsNames = new LinkedList<String>();
    List<Field> columns = getColumnsForInput();
    for (Field field : columns) {
      columnsNames.add(field.getAnnotation(Column.class).name());
    }
    return columnsNames;
  }
  
  public List<String> getColumnsNames() {
    List<String> columnsNames = new LinkedList<String>();
    List<Field> columns = getColumns();
    for (Field field : columns) {
      columnsNames.add(field.getAnnotation(Column.class).name());
    }
    return columnsNames;
  }
  
  public String generateColumnsNamesString() {
    List<String> columns = getColumnsNamesForInput();
    String columnsStringNames = String.join(",", columns);
    return columnsStringNames;
  }
  
  public String generateColumnsParametersString() {
    List<String> columns = getColumnsNamesForInput();
    columns.replaceAll(s -> s = "?");
    String columnsParameters = String.join(",", columns);
    return columnsParameters;
  }

  public String generateUpdateColumnsString() {
    List<String> columns = getColumnsNamesForInput();
    columns.replaceAll(s -> s += "=?");
    String updateColumnsString = String.join(",", columns);
    return updateColumnsString;
  }
  
  public String getTableName() {
    Table table = clazz.getAnnotation(Table.class);
    String tableName = table.name();
    return tableName;
  }

  public E setFieldByName(E entity, String fieldName, Object fieldValue)
      throws IllegalArgumentException, IllegalAccessException {
    for (Field field : fields) {
      if (field.getName().equals(fieldName)) {
        field.setAccessible(true);
        field.set(entity, fieldValue);
        break;
      }
    }
    return entity;
  }

}
