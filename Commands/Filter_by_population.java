package Commands;

import CityObject.City;
import Controller.CollectionCity;
import Controller.Commandable;

public class Filter_by_population implements Commandable {
    @Override
    public void execute(Object arg) {
        boolean tumb = true;
        for (City city : CollectionCity.cities)
            if (city.getPopulation() == Long.parseLong((String) arg)) {
                System.out.println(city.getCity());
                tumb = false;
            }
        if (tumb) System.out.println("Ни один элемент не удовлетворяет условию");
    }

    @Override
    public String getName() {
        return "filter_by_population";
    }
}
