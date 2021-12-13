package fr.esgi.tp5;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new InMemoryUserRepository();
        final UserId userId = userRepository.nextId();
        User user = User.of(userId, "BOISSINOT", "GREGORY", "CHANGEME");
        userRepository.save(user);

        //--- OTHER STAFF

        final User retrievedUser = userRepository.byId(userId);
        System.out.println(retrievedUser);
        retrievedUser.changePassword("MYNEWPASSWORD");
        userRepository.save(retrievedUser);

        //TEST RETRIEVE
        System.out.println(userRepository.byId(userId));
    }
}
