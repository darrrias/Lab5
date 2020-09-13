package Controller;

import CityObject.City;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class CollectionCity {
    public static PriorityQueue<City> cities;
    static LocalDate CreationDate = LocalDate.now();

    public static String info() {
        return "Тип коллекции: PriorityQueue\n" +
                "Время создания:" + CreationDate + "\n" +
                "Количество элементов в коллекции: " + cities.size();
    }

    public static void clear() {
        cities.clear();

    }

    public static void add(City city) {
        cities.add(city);
    }

    public static int size() {
        return cities.size();
    }

    private static long id = 0;

    public static long getFreeId() {
        id++;
        for (City city : cities)
            if (city.getId() == id)
                id++;
        return id;
    }

    public static boolean checkId(long parseLong) {
        for (City city : CollectionCity.cities) {
            if (city.getId() == parseLong) {
                return false;
            }
        }
        return true;
    }
}
