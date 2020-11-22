package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.CreditCardController;
import ua.lviv.iot.uklon.model.entity.CreditCard;
import ua.lviv.iot.uklon.model.service.implementation.CreditCardServiceImpl;

public class CreditCardControllerImpl extends AbstractController<CreditCard, Integer> implements CreditCardController {

  public CreditCardControllerImpl() {
    super(new CreditCardServiceImpl());
  }
}
