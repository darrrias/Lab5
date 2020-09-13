package Commands;

import CityObject.CityCreator;
import Controller.CommandWithObject;
import Controller.Commandable;
import Controller.Invoker;
import Utilites.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Execute_script implements Commandable {

    @Override
    public void execute(Object arg) {
        try {
            String data = Reader.read((String) arg);
            if (data != null) {
                String[] commands = data.split("\n|\r\n");
                for (int i = 0; i < commands.length; i++) {
                    if (!(commands[i].equals(""))) {
                        if (!(commands[i].equals("execute_script " + arg))) {
                            try {
                                String[] commandAndName = commands[i].split(" ");
                                CommandWithObject commandWithObject = (CommandWithObject) Invoker.getCommand(commandAndName[0]);
                                if (commandWithObject != null) {
                                    String[] params = new String[11];
                                    try {
                                        for (int j = 0; j < 11; j++) {
                                            i++;
                                            params[j] = (commands[i]);
                                        }
                                        System.out.print("\nКоманда \"" + commands[i - 11] + "\":");
                                        CityCreator.isInScript = true;
                                        CityCreator.createFromFile(params);
                                        Invoker.execute(commands[i - 11]);
                                        CityCreator.isInScript = false;
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println("Команда \"" + commandAndName + "\":");
                                        System.out.println("Недостаточно параметров");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Команда \"" + commands[i] + "\":");
                                Invoker.execute(commands[i]);
                                System.out.println();
                            }

                        } else System.out.println("Команда \"" + commands[i] + "\": невыполнима.");
                    }
                }
            } else System.out.println("Указанный файл не найден.");
        } catch (NullPointerException | IOException e) {
            System.out.println("Указанный файл не найден.");
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}