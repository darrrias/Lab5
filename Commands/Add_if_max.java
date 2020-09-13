package Commands;

import CityObject.City;
import CityObject.CityCreator;
import Controller.CollectionCity;
import Controller.CommandWithObject;
import Controller.CommandWithoutArg;

public class Add_if_max implements CommandWithObject, CommandWithoutArg {

    @Override
    public void execute(Object arg) {
        try {
            boolean tumb = true;
            City sample = getNewCity();
            for (City city : CollectionCity.cities)
                if (city.compareTo(sample) > 0) tumb = false;
            if (tumb) {
                System.out.println("Город оказался максимальным добавлен в коллекцию");
                CollectionCity.add(sample);
            } else System.out.println("Нашлись города и побольше, Ваш город не был добавлен в коллекцию=(");
        } catch (NullPointerException e) {
        }
    }

    @Override
    public String getName() {
        return "add_if_max";
    }

    @Override
    public City getNewCity() {
        if (CityCreator.isInScript)
            return CityCreator.cityFromFile;
        else return CityCreator.createCity();
    }
}

