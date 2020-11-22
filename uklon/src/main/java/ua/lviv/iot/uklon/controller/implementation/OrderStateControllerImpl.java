package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.OrderStateController;
import ua.lviv.iot.uklon.model.entity.OrderState;
import ua.lviv.iot.uklon.model.service.implementation.OrderStateServiceImpl;

public class OrderStateControllerImpl extends AbstractController<OrderState, Integer> implements OrderStateController {

  public OrderStateControllerImpl() {
    super(new OrderStateServiceImpl());
  }
}
