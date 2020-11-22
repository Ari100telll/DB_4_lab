package ua.lviv.iot.uklon.view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import ua.lviv.iot.uklon.controller.AdressController;
import ua.lviv.iot.uklon.controller.CityController;
import ua.lviv.iot.uklon.controller.CreditCardController;
import ua.lviv.iot.uklon.controller.DriverController;
import ua.lviv.iot.uklon.controller.OrderController;
import ua.lviv.iot.uklon.controller.OrderStateController;
import ua.lviv.iot.uklon.controller.OrderTypeController;
import ua.lviv.iot.uklon.controller.PassengerController;
import ua.lviv.iot.uklon.controller.StreetsController;
import ua.lviv.iot.uklon.controller.VehicleController;
import ua.lviv.iot.uklon.controller.implementation.AdressControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.CityControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.CreditCardControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.DriverControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.OrderControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.OrderStateControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.OrderTypeControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.PassengerControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.StreetsControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.VehicleControllerImpl;
import ua.lviv.iot.uklon.model.entity.Adress;
import ua.lviv.iot.uklon.model.entity.City;
import ua.lviv.iot.uklon.model.entity.CreditCard;
import ua.lviv.iot.uklon.model.entity.Driver;
import ua.lviv.iot.uklon.model.entity.Order;
import ua.lviv.iot.uklon.model.entity.OrderState;
import ua.lviv.iot.uklon.model.entity.OrderType;
import ua.lviv.iot.uklon.model.entity.Passenger;
import ua.lviv.iot.uklon.model.entity.Streets;
import ua.lviv.iot.uklon.model.entity.Vehicle;

public class View {
  private static final String KEY_EXIT = "Q";

  private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";

  private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option: ";
  private static final String TEXT_GO_BACK = "Go back or quit";

  private static Scanner input = new Scanner(System.in, "UTF-8");

  public View() {
  }

  public void show() {
    showTablesMenu();
  }

  private void showTablesMenu() {
    Map<String, String> tablesMenu = generateTablesMenu();
    Map<String, Printable> tablesMenuMethods = generateTablesMenuMethods();
    showMenuFromMaps(tablesMenu, tablesMenuMethods);
  }

  private Map<String, String> generateTablesMenu() {
    Map<String, String> tablesMenu = new LinkedHashMap<String, String>();
    tablesMenu.put("1", "Table: Adress");
    tablesMenu.put("2", "Table: City");
    tablesMenu.put("3", "Table: CreditCard");
    tablesMenu.put("4", "Table: Driver");
    tablesMenu.put("5", "Table: Order");
    tablesMenu.put("6", "Table: OrderState");
    tablesMenu.put("7", "Table: OrderType");
    tablesMenu.put("8", "Table: Passenger");
    tablesMenu.put("9", "Table: Streets");
    tablesMenu.put("10", "Table: Vehicle");
    return tablesMenu;
  }

  private Map<String, Printable> generateTablesMenuMethods() {
    Map<String, Printable> tableMenuMethods = new LinkedHashMap<String, Printable>();
    tableMenuMethods.put("1", this::showAdressMenu);
    tableMenuMethods.put("2", this::showCityMenu);
    tableMenuMethods.put("3", this::showCreditCardMenu);
    tableMenuMethods.put("4", this::showDriverMenu);
    tableMenuMethods.put("5", this::showOrderMenu);
    tableMenuMethods.put("6", this::showOrderStateMenu);
    tableMenuMethods.put("7", this::showOrderTypeMenu);
    tableMenuMethods.put("8", this::showPassengerMenu);
    tableMenuMethods.put("9", this::showStreetsMenu);
    tableMenuMethods.put("10", this::showVehicleMenu);
    return tableMenuMethods;
  }

  private void showAdressMenu() {
    Map<String, String> menu = generateAdressMenu();
    Map<String, Printable> menuMethods = generateAdressMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showCityMenu() {
    Map<String, String> menu = generateCityMenu();
    Map<String, Printable> menuMethods = generateCityMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showCreditCardMenu() {
    Map<String, String> menu = generateCreditCardMenu();
    Map<String, Printable> menuMethods = generateCreditCardMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showDriverMenu() {
    Map<String, String> menu = generateDriverMenu();
    Map<String, Printable> menuMethods = generateDriverMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showOrderMenu() {
    Map<String, String> menu = generateOrderMenu();
    Map<String, Printable> menuMethods = generateOrderMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showOrderStateMenu() {
    Map<String, String> menu = generateOrderStateMenu();
    Map<String, Printable> menuMethods = generateOrderStateMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showOrderTypeMenu() {
    Map<String, String> menu = generateOrderTypeMenu();
    Map<String, Printable> menuMethods = generateOrderTypeMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showPassengerMenu() {
    Map<String, String> menu = generatePassengerMenu();
    Map<String, Printable> menuMethods = generatePassengerMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showStreetsMenu() {
    Map<String, String> menu = generateStreetsMenu();
    Map<String, Printable> menuMethods = generateStreetsMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showVehicleMenu() {
    Map<String, String> menu = generateVehicleMenu();
    Map<String, Printable> menuMethods = generateVehicleMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private Map<String, String> generateAdressMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from Adress");
    menu.put("2", "Select Adress");
    menu.put("3", "Create Adress");
    menu.put("4", "Update Adress");
    menu.put("5", "Delete Adress");
    return menu;
  }

  private Map<String, Printable> generateAdressMenuMethods() {
    AdressController adressController = new AdressControllerImpl();
    Formater<Adress, Integer> formatter = new Formater<>(Adress.class);
    ViewManager<Adress, Integer> adressOperation = new ViewManager<>(adressController, formatter, Adress.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", adressOperation::findAll);
    menuMethods.put("2", adressOperation::findById);
    menuMethods.put("3", adressOperation::create);
    menuMethods.put("4", adressOperation::update);
    menuMethods.put("5", adressOperation::delete);
    return menuMethods;
  }

  private Map<String, String> generateCityMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from City");
    menu.put("2", "Select City");
    menu.put("3", "Create City");
    menu.put("4", "Update City");
    menu.put("5", "Delete City");
    return menu;
  }

  private Map<String, Printable> generateCityMenuMethods() {
    CityController cityController = new CityControllerImpl();
    Formater<City, Integer> formatter = new Formater<>(City.class);
    ViewManager<City, Integer> cityOperation = new ViewManager<>(cityController, formatter, City.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", cityOperation::findAll);
    menuMethods.put("2", cityOperation::findById);
    menuMethods.put("3", cityOperation::create);
    menuMethods.put("4", cityOperation::update);
    menuMethods.put("5", cityOperation::delete);
    return menuMethods;
  }

  private Map<String, String> generateCreditCardMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from CreditCard");
    menu.put("2", "Select CreditCard");
    menu.put("3", "Create CreditCard");
    menu.put("4", "Update CreditCard");
    menu.put("5", "Delete CreditCard");
    return menu;
  }

  private Map<String, Printable> generateCreditCardMenuMethods() {
    CreditCardController controller = new CreditCardControllerImpl();
    Formater<CreditCard, Integer> formatter = new Formater<>(CreditCard.class);
    ViewManager<CreditCard, Integer> operation = new ViewManager<>(controller, formatter, CreditCard.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", operation::findAll);
    menuMethods.put("2", operation::findById);
    menuMethods.put("3", operation::create);
    menuMethods.put("4", operation::update);
    menuMethods.put("5", operation::delete);
    return menuMethods;
  }

  private Map<String, String> generateDriverMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from Driver");
    menu.put("2", "Select Driver");
    menu.put("3", "Create Driver");
    menu.put("4", "Update Driver");
    menu.put("5", "Delete Driver");
    return menu;
  }

  private Map<String, Printable> generateDriverMenuMethods() {
    DriverController controller = new DriverControllerImpl();
    Formater<Driver, Integer> formatter = new Formater<>(Driver.class);
    ViewManager<Driver, Integer> operation = new ViewManager<>(controller, formatter, Driver.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", operation::findAll);
    menuMethods.put("2", operation::findById);
    menuMethods.put("3", operation::create);
    menuMethods.put("4", operation::update);
    menuMethods.put("5", operation::delete);
    return menuMethods;
  }

  private Map<String, String> generateOrderMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from Order");
    menu.put("2", "Select Order");
    menu.put("3", "Create Order");
    menu.put("4", "Update Order");
    menu.put("5", "Delete Order");
    return menu;
  }

  private Map<String, Printable> generateOrderMenuMethods() {
    OrderController controller = new OrderControllerImpl();
    Formater<Order, Integer> formatter = new Formater<>(Order.class);
    ViewManager<Order, Integer> operation = new ViewManager<>(controller, formatter, Order.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", operation::findAll);
    menuMethods.put("2", operation::findById);
    menuMethods.put("3", operation::create);
    menuMethods.put("4", operation::update);
    menuMethods.put("5", operation::delete);
    return menuMethods;
  }

  private Map<String, String> generateOrderStateMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from OrderState");
    menu.put("2", "Select OrderState");
    menu.put("3", "Create OrderState");
    menu.put("4", "Update OrderState");
    menu.put("5", "Delete OrderState");
    return menu;
  }

  private Map<String, Printable> generateOrderStateMenuMethods() {
    OrderStateController controller = new OrderStateControllerImpl();
    Formater<OrderState, Integer> formatter = new Formater<>(OrderState.class);
    ViewManager<OrderState, Integer> operation = new ViewManager<>(controller, formatter, OrderState.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", operation::findAll);
    menuMethods.put("2", operation::findById);
    menuMethods.put("3", operation::create);
    menuMethods.put("4", operation::update);
    menuMethods.put("5", operation::delete);
    return menuMethods;
  }

  private Map<String, String> generateOrderTypeMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from OrderType");
    menu.put("2", "Select OrderType");
    menu.put("3", "Create OrderType");
    menu.put("4", "Update OrderType");
    menu.put("5", "Delete OrderType");
    return menu;
  }

  private Map<String, Printable> generateOrderTypeMenuMethods() {
    OrderTypeController controller = new OrderTypeControllerImpl();
    Formater<OrderType, Integer> formatter = new Formater<>(OrderType.class);
    ViewManager<OrderType, Integer> operation = new ViewManager<>(controller, formatter, OrderType.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", operation::findAll);
    menuMethods.put("2", operation::findById);
    menuMethods.put("3", operation::create);
    menuMethods.put("4", operation::update);
    menuMethods.put("5", operation::delete);
    return menuMethods;
  }

  private Map<String, String> generatePassengerMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from Passenger");
    menu.put("2", "Select Passenger");
    menu.put("3", "Create Passenger");
    menu.put("4", "Update Passenger");
    menu.put("5", "Delete Passenger");
    return menu;
  }

  private Map<String, Printable> generatePassengerMenuMethods() {
    PassengerController controller = new PassengerControllerImpl();
    Formater<Passenger, Integer> formatter = new Formater<>(Passenger.class);
    ViewManager<Passenger, Integer> operation = new ViewManager<>(controller, formatter, Passenger.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", operation::findAll);
    menuMethods.put("2", operation::findById);
    menuMethods.put("3", operation::create);
    menuMethods.put("4", operation::update);
    menuMethods.put("5", operation::delete);
    return menuMethods;
  }

  private Map<String, String> generateStreetsMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from Streets");
    menu.put("2", "Select Streets");
    menu.put("3", "Create Streets");
    menu.put("4", "Update Streets");
    menu.put("5", "Delete Streets");
    return menu;
  }

  private Map<String, Printable> generateStreetsMenuMethods() {
    StreetsController controller = new StreetsControllerImpl();
    Formater<Streets, Integer> formatter = new Formater<>(Streets.class);
    ViewManager<Streets, Integer> operation = new ViewManager<>(controller, formatter, Streets.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", operation::findAll);
    menuMethods.put("2", operation::findById);
    menuMethods.put("3", operation::create);
    menuMethods.put("4", operation::update);
    menuMethods.put("5", operation::delete);
    return menuMethods;
  }

  private Map<String, String> generateVehicleMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all from ");
    menu.put("2", "Select ");
    menu.put("3", "Create ");
    menu.put("4", "Update ");
    menu.put("5", "Delete ");
    return menu;
  }

  private Map<String, Printable> generateVehicleMenuMethods() {
    VehicleController controller = new VehicleControllerImpl();
    Formater<Vehicle, Integer> formatter = new Formater<>(Vehicle.class);
    ViewManager<Vehicle, Integer> operation = new ViewManager<>(controller, formatter, Vehicle.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", operation::findAll);
    menuMethods.put("2", operation::findById);
    menuMethods.put("3", operation::create);
    menuMethods.put("4", operation::update);
    menuMethods.put("5", operation::delete);
    return menuMethods;
  }

  private void showMenuFromMaps(Map<String, String> keyName, Map<String, Printable> keyMethod) {
    String keyMenu;
    do {
      printMenu(keyName);
      System.out.println(TEXT_SELECT_MENU_OPTION);
      keyMenu = input.nextLine().toUpperCase();
      Printable method = keyMethod.get(keyMenu);
      if (method != null) {
        method.print();
      } else if (!keyMenu.equals(KEY_EXIT)) {
        System.out.println(ERROR_NO_SUCH_OPTION);
      }
    } while (!keyMenu.equals(KEY_EXIT));
  }

  private void printMenu(Map<String, String> keyName) {
    for (String key : keyName.keySet()) {
      System.out.format("%3s - %s%n", key, keyName.get(key));
    }
    System.out.format("%3s - %s%n", KEY_EXIT, TEXT_GO_BACK);
  }

}
