package fr.esgi.tp4;

final class LoggingUserInfrastructureService implements UserInfrastructureService {

    private final LoggerService logger;

    LoggingUserInfrastructureService(LoggerService logger) {
        this.logger = logger;
    }

    @Override
    public void save(User user) {
        logger.log(user.toString());
    }
}
