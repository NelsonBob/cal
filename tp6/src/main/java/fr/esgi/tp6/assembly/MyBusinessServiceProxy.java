package fr.esgi.tp6.assembly;

import fr.esgi.tp6.MyAuthenticationService;
import fr.esgi.tp6.MyBusinessService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyBusinessServiceProxy extends MyBusinessService {

    private static final Logger logger = Logger.getLogger(MyBusinessServiceProxy.class.getName());

    private final MyAuthenticationService myAuthenticationService;

    public MyBusinessServiceProxy(MyAuthenticationService myAuthenticationService) {
        this.myAuthenticationService = myAuthenticationService;
    }

    @Override
    public void doSomething() {
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "Beginning processing.");
        }
        long start = System.nanoTime();
        if (myAuthenticationService.authenticate()) {
            super.doSomething();
        }
        long end = System.nanoTime();
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, String.format("Ending with %d ms.", (end - start) / 1000));
        }
    }
}
