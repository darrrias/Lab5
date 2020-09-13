package Commands;

import Controller.CollectionCity;
import Controller.CommandWithoutArg;
import Controller.Commandable;

public class Clear implements CommandWithoutArg {
    @Override
    public void execute(Object arg) {
        if (CollectionCity.size()>0) {
            CollectionCity.clear();
            System.out.println("Коллекция очищена");
        }
        else System.out.println("Коллекция итак пустая");


    }

    @Override
    public String getName() {
        return "clear";
    }
}
