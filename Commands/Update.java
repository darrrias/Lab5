package Commands;

import CityObject.City;
import CityObject.CityCreator;
import Controller.CollectionCity;
import Controller.CommandWithObject;

public class Update implements CommandWithObject {
    @Override
    public City getNewCity() {
        if (CityCreator.isInScript)
            return CityCreator.cityFromFile;
        else return CityCreator.createCity();
    }

    @Override
    public void execute(Object arg) {
        if (!CollectionCity.checkId(Long.parseLong((String) arg))){
            Long cityId= Long.parseLong((String) arg);
            for (City city: CollectionCity.cities){
                if (cityId== city.getId()){
                    CollectionCity.cities.remove(city);
                }
            }
            City newCity = getNewCity();
            newCity.setId(Long.parseLong((String) arg));
            CollectionCity.cities.add(newCity);
            System.out.println("Город успешно обновлен");
        }
        else System.out.println("Нет города с указанным id");
    }

    @Override
    public String getName() {
        return "update";
    }
}
