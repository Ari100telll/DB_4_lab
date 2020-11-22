package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.DriverDataAccess;
import ua.lviv.iot.uklon.model.entity.Driver;

public class DriverDataAccessImpl extends AbstractDataAccess<Driver, Integer> implements DriverDataAccess {

  public DriverDataAccessImpl() {
    super(Driver.class);
  }
}
