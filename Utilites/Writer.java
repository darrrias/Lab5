package Utilites;

import CityObject.City;
import Controller.CollectionCity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Writer {
    public static Scanner in = new Scanner(System.in);
    public static void writeCollection(String filename) {
       try {
           while (filename.equals("")){
               System.out.print("Введите имя файла:\n~ ");
               filename = in.nextLine();
           }
           FileOutputStream outputStream = new FileOutputStream(filename);
           for (City city : CollectionCity.cities) {
               outputStream.write(city.getCSV().getBytes());
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }

    }
}
