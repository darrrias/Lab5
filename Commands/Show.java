package Commands;

import CityObject.City;
import Controller.CollectionCity;
import Controller.CommandWithoutArg;
import Controller.Commandable;

public class Show implements CommandWithoutArg {
    @Override
    public void execute(Object arg) {
        try {
            if (CollectionCity.size() > 0) {
                for (City city : CollectionCity.cities) {
                    //System.out.println(city.getName());
                    System.out.println(city.getCity());
                }
            } else System.out.println("Коллекция пустая");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String getName() {
        return "show";
    }
}
