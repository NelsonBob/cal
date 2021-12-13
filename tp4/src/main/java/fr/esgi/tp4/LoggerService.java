package fr.esgi.tp4;

import java.util.logging.Level;
import java.util.logging.Logger;

final class LoggerService {

    private static final Logger LOGGER = Logger.getLogger(LoggerService.class.getName());

    void log(String message) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, message);
        }
    }
}
