package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.OrderTypeDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.OrderType;
import ua.lviv.iot.uklon.model.service.OrderTypeService;

public class OrderTypeServiceImpl extends AbstractService<OrderType, Integer> implements OrderTypeService {

  public OrderTypeServiceImpl() {
    super(new OrderTypeDataAccessImpl());
  }

}
