package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.OrderController;
import ua.lviv.iot.uklon.model.entity.Order;
import ua.lviv.iot.uklon.model.service.implementation.OrderServiceImpl;

public class OrderControllerImpl extends AbstractController<Order, Integer> implements OrderController {

  public OrderControllerImpl() {
    super(new OrderServiceImpl());
  }
}
