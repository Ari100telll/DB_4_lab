package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.VehicleDataAccess;
import ua.lviv.iot.uklon.model.entity.Vehicle;

public class VehicleDataAccessImpl extends AbstractDataAccess<Vehicle, Integer> implements VehicleDataAccess {

  public VehicleDataAccessImpl() {
    super(Vehicle.class);
  }
}
