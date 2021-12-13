package fr.esgi.demo.cours.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Application service
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userDatabaseService) {
        this.userRepository = userDatabaseService;
    }

    public void addUser(User user) {
        userRepository.add(user);
    }

    public void changePassword(String userId, String newPassword) {
        final User user = userRepository.get(userId);
        user.changePassword(newPassword);
        userRepository.add(user);
    }
}
