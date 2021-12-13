package fr.esgi.tp11.withdao;

import fr.esgi.tp11.User;

public class MySQLUserDAO implements UserDao {
    @Override
    public User findById(int userId) {
        return null;
    }

    @Override
    public void createUser(User user) {
        //Do nothing
    }

    @Override
    public void deleteUser(int userId) {
        //Do nothing
    }

    @Override
    public void modifyUser(int userId, User user) {
        //Do nothing
    }
}
