package ua.lviv.iot.uklon.view;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.annotation.Column;
import ua.lviv.iot.uklon.model.manager.EntityManager;

public class ViewManager<E, K> {

  private static final String ERROR_NO_MATCHES_FOUND = "[Error] No matches found";
  private static final String ERROR_MODIFY = "[Error] Unable to create or modify this object";
  private static final String ERROR_INVALID_VALUE = "[Error] Entered invalid value";
  private static final String ERROR_SQL = "[Error] Error while executing SQL";
  private static final String ERROR_MESSAGE_FORMAT = "[Error] Message: %s";

  private static final String KEY_EXIT = "Q";
  private static final String TEXT_ENTER_FIELD_FORMAT = "Enter %s: ";
  private static final String TEXT_CHOOSE_FIELD = "Choose fild to update (enter name):";
  private static final String TEXT_ENTER_FIELD_OR_QUIT_FORMAT = "Enter %s or press '" + KEY_EXIT + "' to go back: ";

  private static Scanner input = new Scanner(System.in, "UTF-8");

  private Controller<E, K> controller;
  private Formater<E, K> formatter;
  private Class<E> entityClass;

  public ViewManager(Controller<E, K> controller, Formater<E, K> formatter, Class<E> entityClass) {
    this.controller = controller;
    this.formatter = formatter;
    this.entityClass = entityClass;
  }

  public void findAll() {
    try {
      List<E> entities = controller.findAll();
      if (entities != null) {
        formatter.formatTable(entities);
      } else {
        System.out.println(ERROR_NO_MATCHES_FOUND);
      }
    } catch (SQLException e) {
      System.out.println(ERROR_SQL);
      System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
    }
  }

  public void findById() {
    String keyMenu;
    do {
      System.out.println(String.format(TEXT_ENTER_FIELD_OR_QUIT_FORMAT, "id"));
      keyMenu = input.nextLine().toUpperCase();
      if (!keyMenu.equals(KEY_EXIT)) {
        try {
          Integer id = Integer.parseInt(keyMenu);
          @SuppressWarnings("unchecked")
          E foundEntity = controller.findById((K) id);
          if (foundEntity != null) {
            formatter.formatRow(foundEntity);
            return;
          } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
          }
        } catch (NumberFormatException e) {
          System.out.println(ERROR_INVALID_VALUE);
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        } catch (SQLException e) {
          System.out.println(ERROR_SQL);
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
      }

    } while (!keyMenu.equals(KEY_EXIT));
  }

  public void create() {
    EntityManager<E, K> entityManager = new EntityManager<>(entityClass);
    Field[] fields = entityManager.getColumnsForInput().toArray(new Field[0]);
    try {
      E entity = entityManager.getEntityClass().getConstructor().newInstance();
      for (Field field : fields) {
        inputValueForField(field, entity);
      }
      E newEntity = controller.create(entity);
      if (newEntity != null) {
        formatter.formatRow(newEntity);
        return;
      } else {
        System.out.println(ERROR_MODIFY);
      }
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException e) {
      System.out.println(ERROR_MODIFY);
      System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
    } catch (SQLException e) {
      System.out.println(ERROR_SQL);
      System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
    }
  }

  public void update() {
    String keyMenu;
    do {
      System.out.println(String.format(TEXT_ENTER_FIELD_OR_QUIT_FORMAT, "id"));
      keyMenu = input.nextLine().toUpperCase();
      if (!keyMenu.equals(KEY_EXIT)) {
        try {
          Integer id = Integer.parseInt(keyMenu);
          @SuppressWarnings("unchecked")
          E foundEntity = controller.findById((K) id);
          if (foundEntity != null) {
            EntityManager<E, K> entityManager = new EntityManager<>(entityClass);
            List<String> columnsNames = entityManager.getColumnsNamesForInput();
            while (true) {
              System.out.println(TEXT_CHOOSE_FIELD);
              for (String columnName : columnsNames) {
                System.out.println(" - " + columnName);
              }
              String inputName = input.nextLine();
              if (columnsNames.contains(inputName)) {
                Field[] fields = entityManager.getColumnsForInput().toArray(new Field[0]);
                Field foundField = getFieldByName(fields, inputName);
                inputValueForField(foundField, foundEntity);
                @SuppressWarnings("unchecked")
                E oldEntity = controller.update((K) id, foundEntity);
                if (oldEntity != null) {
                  @SuppressWarnings("unchecked")
                  E newEntity = controller.findById((K) id);
                  List<E> entityHistory = new LinkedList<E>();
                  entityHistory.add(oldEntity);
                  entityHistory.add(newEntity);
                  formatter.formatTable(entityHistory);
                  return;
                } else {
                  System.out.println(ERROR_MODIFY);
                }
              } else {
                System.out.println(ERROR_NO_MATCHES_FOUND);
              }
            }
          } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
          }
        } catch (NumberFormatException e) {
          System.out.println(ERROR_INVALID_VALUE);
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        } catch (SQLException e) {
          System.out.println(ERROR_SQL);
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        } catch (IllegalArgumentException | IllegalAccessException e) {
          System.out.println(ERROR_MODIFY);
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
      }

    } while (!keyMenu.equals(KEY_EXIT));
  }

  public void delete() {
    String keyMenu;
    do {
      System.out.println(String.format(TEXT_ENTER_FIELD_OR_QUIT_FORMAT, "id"));
      keyMenu = input.nextLine().toUpperCase();
      if (!keyMenu.equals(KEY_EXIT)) {
        try {
          Integer id = Integer.parseInt(keyMenu);
          @SuppressWarnings("unchecked")
          E deletedEntity = controller.delete((K) id);
          if (deletedEntity != null) {
            formatter.formatRow(deletedEntity);
            return;
          } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
          }
        } catch (NumberFormatException e) {
          System.out.println(ERROR_INVALID_VALUE);
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        } catch (SQLException e) {
          System.out.println(ERROR_SQL);
          System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
      }

    } while (!keyMenu.equals(KEY_EXIT));
  }

  private void inputValueForField(Field field, E entity) throws IllegalArgumentException, IllegalAccessException {
    Column column = field.getAnnotation(Column.class);
    String columnName = column.name();
    Integer columnLength = column.length();
    Class<?> fieldType = field.getType();
    String limitation = null;
    if (fieldType == Integer.class) {
      limitation = "max value - " + Integer.MAX_VALUE;
    } else if (fieldType == String.class) {
      limitation = "max length - " + columnLength;
    } else if (fieldType == Date.class) {
      limitation = "format yyyy-mm-dd";
    } else if (fieldType == Float.class) {
      limitation = "format xxx.xx";
    }

    while (true) {
      System.out.println(String.format(TEXT_ENTER_FIELD_FORMAT, String.format("%s (%s)", columnName, limitation)));
      String inputText = input.nextLine();
      try {
        if (fieldType == Integer.class) {
          Integer value = Integer.parseInt(inputText);
          field.setAccessible(true);
          field.set(entity, value);
          break;
        } else if (fieldType == String.class) {
          if (inputText.length() <= columnLength) {
            field.setAccessible(true);
            field.set(entity, inputText);
            break;
          } else {
            System.out.println(ERROR_INVALID_VALUE);
          }
        } else if (fieldType == Date.class) {
          Date date = Date.valueOf(inputText);
          field.setAccessible(true);
          field.set(entity, date);
          break;
        } else if (fieldType == Float.class) {
          Float value = Float.parseFloat(inputText);
          field.setAccessible(true);
          field.set(entity, value);
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println(ERROR_INVALID_VALUE);
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      } catch (IllegalArgumentException e) {
        System.out.println(ERROR_INVALID_VALUE);
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
      }
    }
  }

  private Field getFieldByName(Field[] fields, String fieldName) {
    for (Field field : fields) {
      if (field.getAnnotation(Column.class).name().equals(fieldName)) {
        return field;
      }
    }
    return null;
  }

}