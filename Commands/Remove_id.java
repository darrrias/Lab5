package Commands;

import CityObject.City;
import Controller.CollectionCity;
import Controller.Commandable;

public class Remove_id implements Commandable {
    @Override
    public void execute(Object arg) {
        City city1 = null;
        boolean flag= false;
        Long cityId= Long.parseLong((String) arg);
        for (City city: CollectionCity.cities){
            if (cityId== city.getId()){
                city1=city;
                flag=true;
            }
        }
        if (flag){
            CollectionCity.cities.remove(city1);
            System.out.println("Элемент с id "+cityId+" удален");
        }
        else System.out.println("Элемент не существует");

    }

    @Override
    public String getName() {
        return "remove_by_id";
    }
}
