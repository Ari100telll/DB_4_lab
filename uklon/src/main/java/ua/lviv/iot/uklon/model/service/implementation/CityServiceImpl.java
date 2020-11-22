package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.CityDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.City;
import ua.lviv.iot.uklon.model.service.CityService;

public class CityServiceImpl extends AbstractService<City, Integer> implements CityService {

  public CityServiceImpl() {
    super(new CityDataAccessImpl());
  }

}
