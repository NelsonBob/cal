package fr.esgi.tp1601.application;

import fr.esgi.tp1601.domain.User;
import fr.esgi.tp1601.domain.UserId;
import fr.esgi.tp1601.domain.UserRepository;

public final class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserId create(CreateUser createUser) {
        final UserId userId = userRepository.nextIdentity();
        User user = new User(userId, createUser.lastname, createUser.firstname, createUser.password);
        userRepository.add(user);
        return userId;
    }

    public void changePassword(ChangePassword changePassword) {
        UserId userId = new UserId(changePassword.userId);
        final User user = userRepository.findById(userId);
        user.changePassword(changePassword.newPassword);
        userRepository.add(user);
    }

    public void delete(DeleteUser deleteUser) {
        UserId userId = new UserId(deleteUser.userId);
        userRepository.delete(userId);
    }
}
