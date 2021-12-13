package fr.esgi.tp11.withrepository;

import fr.esgi.tp11.User;
import fr.esgi.tp11.kernel.Repository;

import java.util.List;

@Repository(value = "Users")
public interface Users {

    User findById(int userId) throws NoSuchUserException;

    List<User> findByCity(String city);

    void add(User user);
}
