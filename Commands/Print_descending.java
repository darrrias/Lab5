package Commands;

import CityObject.City;
import Controller.CollectionCity;
import Controller.CommandWithoutArg;
import Controller.Commandable;

import java.util.PriorityQueue;

public class Print_descending implements CommandWithoutArg {
    @Override
    public void execute(Object arg) {
        if (CollectionCity.cities.size() > 0) {
            PriorityQueue<City> queue = new PriorityQueue<>(CollectionCity.cities);
            int size = queue.size();
            for (int i = 0;i<size;i++) {
                City city = queue.peek();
                for (City city2 : queue) {
                    if (city.compareTo(city2) < 0) {
                        city = city2;
                    }
                }
                System.out.println(city.getCity());
                queue.remove(city);
            }


        }

    }

    @Override
    public String getName() {
        return "print_descending";
    }
}
