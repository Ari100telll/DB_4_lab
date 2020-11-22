package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.PassengerController;
import ua.lviv.iot.uklon.model.entity.Passenger;
import ua.lviv.iot.uklon.model.service.implementation.PassengerServiceImpl;

public class PassengerControllerImpl extends AbstractController<Passenger, Integer> implements PassengerController {

  public PassengerControllerImpl() {
    super(new PassengerServiceImpl());
  }
}
