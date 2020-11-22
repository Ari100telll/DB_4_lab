package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.CityController;
import ua.lviv.iot.uklon.model.entity.City;
import ua.lviv.iot.uklon.model.service.implementation.CityServiceImpl;

public class CityControllerImpl extends AbstractController<City, Integer> implements CityController {

  public CityControllerImpl() {
    super(new CityServiceImpl());
  }
}
