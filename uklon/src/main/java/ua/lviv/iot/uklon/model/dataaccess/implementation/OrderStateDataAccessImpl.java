package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.OrderStateDataAccess;
import ua.lviv.iot.uklon.model.entity.OrderState;

public class OrderStateDataAccessImpl extends AbstractDataAccess<OrderState, Integer> implements OrderStateDataAccess {

  public OrderStateDataAccessImpl() {
    super(OrderState.class);
  }
}
