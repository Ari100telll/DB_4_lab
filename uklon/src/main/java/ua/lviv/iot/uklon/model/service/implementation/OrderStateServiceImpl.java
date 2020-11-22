package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.OrderStateDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.OrderState;
import ua.lviv.iot.uklon.model.service.OrderStateService;

public class OrderStateServiceImpl extends AbstractService<OrderState, Integer> implements OrderStateService {

  public OrderStateServiceImpl() {
    super(new OrderStateDataAccessImpl());
  }

}
