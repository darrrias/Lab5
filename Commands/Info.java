package Commands;

import Controller.CollectionCity;
import Controller.CommandWithoutArg;
import Controller.Commandable;

public class Info implements CommandWithoutArg {
    @Override
    public void execute(Object arg) {
        System.out.println(CollectionCity.info());

    }

    @Override
    public String getName() {
        return "info";
    }
}
