package fr.esgi.tp1602.use_cases.user.application;

import fr.esgi.tp1602.kernel.CommandHandler;
import fr.esgi.tp1602.use_cases.user.domain.Address;
import fr.esgi.tp1602.use_cases.user.domain.User;
import fr.esgi.tp1602.use_cases.user.domain.UserId;
import fr.esgi.tp1602.use_cases.user.domain.UserRepository;

public final class CreateUserCommandHandler implements CommandHandler<CreateUser, UserId> {

    private final UserRepository userRepository;

    public CreateUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserId handle(CreateUser createUser) {
        final UserId userId = userRepository.nextIdentity();
        User user = new User(userId, createUser.lastname, createUser.firstname, new Address(createUser.address.city));
        userRepository.add(user);
        return userId;
    }
}
