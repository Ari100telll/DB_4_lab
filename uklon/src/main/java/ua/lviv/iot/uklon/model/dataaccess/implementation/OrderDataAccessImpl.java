package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.OrderDataAccess;
import ua.lviv.iot.uklon.model.entity.Order;

public class OrderDataAccessImpl extends AbstractDataAccess<Order, Integer> implements OrderDataAccess {

  public OrderDataAccessImpl() {
    super(Order.class);
  }
}
