package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.CreditCardDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.CreditCard;
import ua.lviv.iot.uklon.model.service.CreditCardService;

public class CreditCardServiceImpl extends AbstractService<CreditCard, Integer> implements CreditCardService {

  public CreditCardServiceImpl() {
    super(new CreditCardDataAccessImpl());
  }

}
