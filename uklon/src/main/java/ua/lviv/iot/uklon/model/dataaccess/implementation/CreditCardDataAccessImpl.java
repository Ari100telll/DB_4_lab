package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.CreditCardDataAccess;
import ua.lviv.iot.uklon.model.entity.CreditCard;

public class CreditCardDataAccessImpl extends AbstractDataAccess<CreditCard, Integer> implements CreditCardDataAccess {

  public CreditCardDataAccessImpl() {
    super(CreditCard.class);
  }
}
