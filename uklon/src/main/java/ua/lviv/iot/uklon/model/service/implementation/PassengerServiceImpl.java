package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.PassengerDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Passenger;
import ua.lviv.iot.uklon.model.service.PassengerService;

public class PassengerServiceImpl extends AbstractService<Passenger, Integer> implements PassengerService {

  public PassengerServiceImpl() {
    super(new PassengerDataAccessImpl());
  }

}
