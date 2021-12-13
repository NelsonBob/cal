package fr.esgi.tp4;

final class Main {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        User user = User.of("BOISSINOT", "GREGORY");
        var jdbcUserServiceInfrastructure = new JdbcUserInfrastructureService();
        var loggingUserServiceInfrastructure = new LoggingUserInfrastructureService(new LoggerService());
        var userServiceInfrastructure = loggingUserServiceInfrastructure;
        userServiceInfrastructure.save(user);
    }
}
