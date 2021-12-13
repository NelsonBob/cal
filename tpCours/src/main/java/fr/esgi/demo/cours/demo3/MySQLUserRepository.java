package fr.esgi.demo.cours.demo3;

public class MySQLUserRepository implements UserRepository {

    @Override
    public User get(String userId) {
        return null;
    }

    @Override
    public void add(User user) {
        System.out.println("Add user into MySQL");
    }
}
