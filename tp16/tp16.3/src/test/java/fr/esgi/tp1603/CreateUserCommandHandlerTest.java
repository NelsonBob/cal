package fr.esgi.tp1603;

import fr.esgi.tp1603.use_cases.user.application.AddressDTO;
import fr.esgi.tp1603.use_cases.user.application.CreateUser;
import fr.esgi.tp1603.use_cases.user.application.CreateUserCommandHandler;
import fr.esgi.tp1603.use_cases.user.domain.Address;
import fr.esgi.tp1603.use_cases.user.domain.User;
import fr.esgi.tp1603.use_cases.user.domain.UserId;
import fr.esgi.tp1603.use_cases.user.domain.UserRepository;
import fr.esgi.tp1603.use_cases.user.infrastructure.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateUserCommandHandlerTest {

    @Test
    void createUser() {
        UserRepository userRepository = new InMemoryUserRepository();
        CreateUserCommandHandler userCommandHandler = new CreateUserCommandHandler(userRepository);

        CreateUser createdUser = new CreateUser("BOISSINOT", "GREGORY", new AddressDTO("CITY"));
        final UserId userId = userCommandHandler.handle(createdUser);

        final User storedUser = userRepository.findById(userId);
        assertEquals(new User(userId, createdUser.lastname, createdUser.firstname, new Address(createdUser.address.city)), storedUser);
    }
}
