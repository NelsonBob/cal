package fr.esgi.tp11.withdao;

import fr.esgi.tp11.User;

public interface UserDao {

    User findById(int userId);

    void createUser(User user);

    void deleteUser(int userId);

    void modifyUser(int userId, User user);
}
