package fr.esgi.tp11.withrepository;

import fr.esgi.tp11.User;

import java.util.List;

public class MySQLUsers implements Users {
    @Override
    public User findById(int userId) throws NoSuchUserException {
        return null;
    }

    @Override
    public List<User> findByCity(String city) {
        return null;
    }

    @Override
    public void add(User user) {

    }
}
