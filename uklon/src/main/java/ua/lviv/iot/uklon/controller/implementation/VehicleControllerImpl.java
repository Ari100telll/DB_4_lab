package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.VehicleController;
import ua.lviv.iot.uklon.model.entity.Vehicle;
import ua.lviv.iot.uklon.model.service.implementation.VehicleServiceImpl;

public class VehicleControllerImpl extends AbstractController<Vehicle, Integer> implements VehicleController {

  public VehicleControllerImpl() {
    super(new VehicleServiceImpl());
  }
}
