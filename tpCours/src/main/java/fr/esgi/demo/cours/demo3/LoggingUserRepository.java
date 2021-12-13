package fr.esgi.demo.cours.demo3;

public class LoggingUserRepository implements UserRepository {
    @Override
    public User get(String userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(User user) {
        throw new UnsupportedOperationException();
    }
}
