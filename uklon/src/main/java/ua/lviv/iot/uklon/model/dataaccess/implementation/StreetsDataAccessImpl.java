package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.StreetsDataAccess;
import ua.lviv.iot.uklon.model.entity.Streets;

public class StreetsDataAccessImpl extends AbstractDataAccess<Streets, Integer> implements StreetsDataAccess {

  public StreetsDataAccessImpl() {
    super(Streets.class);
  }
}
