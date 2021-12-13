package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.CommandHandler;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.user.domain.Address;
import fr.esgi.tp1605.use_cases.user.domain.User;
import fr.esgi.tp1605.use_cases.user.domain.UserId;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CreateUserCommandHandler implements CommandHandler<CreateUser, UserId> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    @Autowired
    public CreateUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public UserId handle(CreateUser createUser) {
        final UserId userId = userRepository.nextIdentity();
        User user = new User(userId, createUser.lastname, createUser.firstname, new Address(createUser.address.city));
        userRepository.add(user);
        eventEventDispatcher.dispatch(new CreateUserEvent(userId));
        return userId;
    }
}
