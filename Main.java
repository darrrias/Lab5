import Commands.*;
import Controller.CollectionCity;
import Controller.Invoker;
import Utilites.Reader;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = System.getenv("collection");
        if (filename == null) filename = "";
        CollectionCity.cities = Reader.parse(Reader.read(filename));
        Invoker.regist(new Help(), new Add(), new Info(), new Clear(), new Show(), new Remove_id(),
                new Remove_first(), new Print_descending(), new Execute_script(), new Save(),
                new Exit(), new Filter_by_population(), new Filter_greater_than_standard_of_living(),
                new Add_if_max(), new Update());
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("~ ");
            Invoker.execute(in.nextLine());
        }
    }
}
