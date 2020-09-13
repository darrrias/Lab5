package Commands;

import Controller.CommandWithoutArg;
import Utilites.Reader;
import Utilites.Writer;

public class Save implements CommandWithoutArg {
    @Override
    public void execute(Object arg) {
        Writer.writeCollection(Reader.file);
        System.out.println("Коллекция успешно сохранена");
    }

    @Override
    public String getName() {
        return "save";
    }
}
