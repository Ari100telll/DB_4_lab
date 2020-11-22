package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.DriverController;
import ua.lviv.iot.uklon.model.entity.Driver;
import ua.lviv.iot.uklon.model.service.implementation.DriverServiceImpl;

public class DriverControllerImpl extends AbstractController<Driver, Integer> implements DriverController {

  public DriverControllerImpl() {
    super(new DriverServiceImpl());
  }
}
