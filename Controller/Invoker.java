package Controller;

import java.util.HashMap;

public class Invoker {
    static HashMap<String, Commandable> commands = new HashMap<String, Commandable>();

    public static void regist(Commandable... commandables) {
        for (Commandable command : commandables) {
            commands.put(command.getName(), command);
        }
    }

    public static void execute(String commandName) {
        String[] nameAndArgument = commandName.split(" ");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
            } else {
                try {
                    CommandWithoutArg commandWithoutArg = (CommandWithoutArg) commands.get(nameAndArgument[0]);
                    try {
                        String s = nameAndArgument[1];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (Exception e) {
                        commands.get(nameAndArgument[0]).execute(null);
                    }
                } catch (Exception e) {
                    try {
                        String s = nameAndArgument[2];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            commands.get(nameAndArgument[0]).execute(nameAndArgument[1]);
                        } catch (IndexOutOfBoundsException e2) {
                            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        }
                    }
                }
            }
        }
    }

    public static Commandable getCommand(String commandname) {
        return commands.get(commandname);
    }
}
