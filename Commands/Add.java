package Commands;

import CityObject.City;
import CityObject.CityCreator;
import Controller.CollectionCity;
import Controller.CommandWithObject;
import Controller.CommandWithoutArg;
import Controller.ScriptException;

public class Add implements CommandWithObject, CommandWithoutArg {

    @Override
    public void execute(Object arg) {
        try {
            CollectionCity.add(getNewCity());
            System.out.println("Город успешно построен и добавлен в коллекцию");
        }
        catch (NullPointerException e){
        }
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public City getNewCity() {
        if (CityCreator.isInScript)
            return CityCreator.cityFromFile;
        else return CityCreator.createCity();
    }
}
