package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.PassengerDataAccess;
import ua.lviv.iot.uklon.model.entity.Passenger;

public class PassengerDataAccessImpl extends AbstractDataAccess<Passenger, Integer> implements PassengerDataAccess {

  public PassengerDataAccessImpl() {
    super(Passenger.class);
  }
}
