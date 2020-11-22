package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.OrderDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Order;
import ua.lviv.iot.uklon.model.service.OrderService;

public class OrderServiceImpl extends AbstractService<Order, Integer> implements OrderService {

  public OrderServiceImpl() {
    super(new OrderDataAccessImpl());
  }

}
