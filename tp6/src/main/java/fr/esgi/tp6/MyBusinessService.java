package fr.esgi.tp6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyBusinessService {

    private static final Logger logger = Logger.getLogger(MyBusinessService.class.getName());

    public void doSomething() {
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "Do something");
        }
    }
}
