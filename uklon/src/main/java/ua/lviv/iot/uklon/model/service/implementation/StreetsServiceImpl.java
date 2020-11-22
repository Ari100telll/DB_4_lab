package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.StreetsDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Streets;
import ua.lviv.iot.uklon.model.service.StreetsService;

public class StreetsServiceImpl extends AbstractService<Streets, Integer> implements StreetsService {

  public StreetsServiceImpl() {
    super(new StreetsDataAccessImpl());
  }

}
