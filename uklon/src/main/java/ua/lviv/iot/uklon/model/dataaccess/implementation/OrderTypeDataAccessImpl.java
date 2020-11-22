package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.OrderTypeDataAccess;
import ua.lviv.iot.uklon.model.entity.OrderType;

public class OrderTypeDataAccessImpl extends AbstractDataAccess<OrderType, Integer> implements OrderTypeDataAccess {

  public OrderTypeDataAccessImpl() {
    super(OrderType.class);
  }
}
