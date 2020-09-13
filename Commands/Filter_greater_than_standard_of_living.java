package Commands;

import CityObject.City;
import CityObject.StandardOfLiving;
import Controller.CollectionCity;
import Controller.Commandable;

public class Filter_greater_than_standard_of_living implements Commandable {
    @Override
    public void execute(Object arg) {
       try {
           boolean tumb= true;
           for (City city : CollectionCity.cities)
               if (city.getStandardOfLiving().getLevel() >
                       StandardOfLiving.valueOf(((String) arg).toUpperCase()).getLevel()) {
                   System.out.println(city.getCity());
                   tumb = false;
               }
           if (tumb) System.out.println("Ни один элемент не удовлетворяет условию");
       }catch (IllegalArgumentException e){
           System.out.println("Аргументами этой команды могут быть только значения: VERY_HIGH, HIGH, VERY_LOW");
       }
    }

    @Override
    public String getName() {
        return "filter_greater_than_standard_of_living";
    }
}
