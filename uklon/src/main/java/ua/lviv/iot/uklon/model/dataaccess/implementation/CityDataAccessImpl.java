package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.CityDataAccess;
import ua.lviv.iot.uklon.model.entity.City;

public class CityDataAccessImpl extends AbstractDataAccess<City, Integer> implements CityDataAccess {

  public  CityDataAccessImpl() {
    super(City.class);
  }
}
