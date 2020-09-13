package Commands;
import Controller.CommandWithoutArg;

public class Exit implements CommandWithoutArg {
    @Override
    public void execute(Object arg) {

        System.exit(0);

    }

    @Override
    public String getName() {
        return "exit";
    }
}
