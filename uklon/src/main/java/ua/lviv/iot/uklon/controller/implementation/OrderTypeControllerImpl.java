package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.OrderTypeController;
import ua.lviv.iot.uklon.model.entity.OrderType;
import ua.lviv.iot.uklon.model.service.implementation.OrderTypeServiceImpl;

public class OrderTypeControllerImpl extends AbstractController<OrderType, Integer> implements OrderTypeController {

  public OrderTypeControllerImpl() {
    super(new OrderTypeServiceImpl());
  }
}
