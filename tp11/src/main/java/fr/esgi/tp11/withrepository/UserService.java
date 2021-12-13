package fr.esgi.tp11.withrepository;

import fr.esgi.tp11.User;

public class UserService {

    private final Users users;

    public UserService(Users users) {
        this.users = users;
    }

    void createUser(User user) {
        users.add(user);
    }

    void changePassword(int userId, String newPassword) {
        final User user = users.findById(userId);
        user.changePassword(newPassword);
        users.add(user);
    }
}
