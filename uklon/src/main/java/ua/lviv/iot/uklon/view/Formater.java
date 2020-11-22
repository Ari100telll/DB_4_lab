package ua.lviv.iot.uklon.view;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.manager.EntityManager;

public class Formater<E, K> {

  private EntityManager<E, K> entityManager;
  
  public Formater(Class<E> clazz) {
    entityManager = new EntityManager<>(clazz);
  }
  
  public void formatTable(List<E> entities) {
    try {
      StringBuffer format = new StringBuffer();
      format.append("| ");
      int[] columnLengthes;

      columnLengthes = getColumnLengthes(entities);
      for (int i = 0; i < columnLengthes.length; i++) {
        format.append("%-").append(columnLengthes[i]).append("s | ");
      }
      String[] columns = getColumnNames();
      String formattedNames = String.format(format.toString(), (Object[]) columns);
      String delimitter = formattedNames.replaceAll("[^|]", "-").replace("|", "+");
      delimitter = delimitter.substring(0, delimitter.length() - 1);

      System.out.println(delimitter);
      System.out.println(formattedNames);
      System.out.println(delimitter);
      for (E entity : entities) {
        System.out.println(String.format(format.toString(), (Object[]) propertiesToArray(entity)));
      }
      System.out.println(delimitter);
    } catch (IllegalArgumentException | IllegalAccessException e) {
      System.out.println("[Error] Exeption while preparing to format data");
      System.out.println("[Error] Message: " + e.getMessage());
    }
  }

  public void formatRow(E entity) {
    List<E> singleEntityList = new LinkedList<E>();
    singleEntityList.add(entity);
    formatTable(singleEntityList);
  }
  
  private String[] getColumnNames() {
    String[] fieldNames = entityManager.getColumnsNames().toArray(new String[0]);
    return fieldNames;
  }
  
  private int[] getColumnLengthes(List<E> entities) throws IllegalArgumentException, IllegalAccessException {
    Field[] columns = entityManager.getColumns().toArray(new Field[0]);
    int[] lengthes = new int[columns.length];
    for (E entity : entities) {
      for (int i = 0; i < columns.length; i++) {
        if (columns[i].isAnnotationPresent(Column.class)) {
          columns[i].setAccessible(true);
          if (columns[i].get(entity) != null) {
            int fieldLength = columns[i].get(entity).toString().length();
            lengthes[i] = lengthes[i] < fieldLength ? fieldLength : lengthes[i];
          }
        }
      }
    }
    String[] fieldNames = getColumnNames();
    for (int i = 0; i < fieldNames.length; i++) {
      int fieldNameLength = fieldNames[i].length();
      lengthes[i] = lengthes[i] < fieldNameLength ? fieldNameLength : lengthes[i];
    }

    return lengthes;
  }
  
  private String[] propertiesToArray(E entity) throws IllegalArgumentException, IllegalAccessException {
    Field[] columns = entityManager.getColumns().toArray(new Field[0]);
    String[] properties = new String[columns.length];
    for (int i = 0; i < columns.length; i++) {
      columns[i].setAccessible(true);
      if (columns[i].get(entity) != null) {
        properties[i] = columns[i].get(entity).toString();
      } else {
        properties[i] = "-";
      }
    }
    return properties;
  }
}
