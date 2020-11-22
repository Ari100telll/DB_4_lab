package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.VehicleDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Vehicle;
import ua.lviv.iot.uklon.model.service.VehicleService;

public class VehicleServiceImpl extends AbstractService<Vehicle, Integer> implements VehicleService {

  public VehicleServiceImpl() {
    super(new VehicleDataAccessImpl());
  }

}
