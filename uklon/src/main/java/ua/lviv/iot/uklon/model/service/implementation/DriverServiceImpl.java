package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.DriverDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Driver;
import ua.lviv.iot.uklon.model.service.DriverService;

public class DriverServiceImpl extends AbstractService<Driver, Integer> implements DriverService {

  public DriverServiceImpl() {
    super(new DriverDataAccessImpl());
  }

}
