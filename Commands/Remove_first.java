package Commands;

import Controller.CollectionCity;
import Controller.CommandWithoutArg;
import Controller.Commandable;

public class Remove_first implements CommandWithoutArg {
    @Override
    public void execute(Object arg) {
        if (CollectionCity.cities.size()>0){
        CollectionCity.cities.poll();
            System.out.println("Первый элемент удален");
    }
        else System.out.println("Коллекция пустая");}

    @Override
    public String getName() {
        return "remove_first";
    }
}
