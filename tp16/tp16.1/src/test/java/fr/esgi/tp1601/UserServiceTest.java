package fr.esgi.tp1601;

import fr.esgi.tp1601.application.CreateUser;
import fr.esgi.tp1601.application.UserService;
import fr.esgi.tp1601.domain.User;
import fr.esgi.tp1601.domain.UserId;
import fr.esgi.tp1601.domain.UserRepository;
import fr.esgi.tp1601.infrastructure.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Test
    void createUser() {
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        CreateUser createdUser = new CreateUser("BOISSINOT", "GREGORY", "MYFIRST_PASSWORD");
        final UserId userId = userService.create(createdUser);

        final User storedUser = userRepository.findById(userId);
        assertEquals(new User(userId, createdUser.lastname, createdUser.firstname, createdUser.password), storedUser);
    }
}
