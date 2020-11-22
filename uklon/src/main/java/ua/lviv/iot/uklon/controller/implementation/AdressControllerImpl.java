package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.AdressController;
import ua.lviv.iot.uklon.model.entity.Adress;
import ua.lviv.iot.uklon.model.service.implementation.AdressServiceImpl;

public class AdressControllerImpl extends AbstractController<Adress, Integer> implements AdressController {

  public AdressControllerImpl() {
    super(new AdressServiceImpl());
  }
}
