package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.AdressDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Adress;
import ua.lviv.iot.uklon.model.service.AdressService;

public class AdressServiceImpl extends AbstractService<Adress, Integer> implements AdressService {

  public AdressServiceImpl() {
    super(new AdressDataAccessImpl());
  }

}
