package Controller;

import java.io.FileNotFoundException;

public interface Commandable {
    void execute(Object arg);
    String getName();
}
