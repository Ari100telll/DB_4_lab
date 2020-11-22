package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.StreetsController;
import ua.lviv.iot.uklon.model.entity.Streets;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;

public class StreetsControllerImpl extends AbstractController<Streets, Integer> implements StreetsController {

  public StreetsControllerImpl() {
    super(new StreetsServiceImpl());
  }
}
