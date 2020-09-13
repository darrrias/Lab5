package Controller;

import CityObject.City;

public interface CommandWithObject extends Commandable{
    City getNewCity();
}
