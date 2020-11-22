package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.AdressDataAccess;
import ua.lviv.iot.uklon.model.entity.Adress;

public class AdressDataAccessImpl extends AbstractDataAccess<Adress, Integer> implements AdressDataAccess {

    public AdressDataAccessImpl() {
      super(Adress.class);
    }
}
