package fr.esgi.tp1606.use_cases.user.application;

import fr.esgi.tp1606.kernel.CommandHandler;
import fr.esgi.tp1606.kernel.Event;
import fr.esgi.tp1606.kernel.EventDispatcher;
import fr.esgi.tp1606.use_cases.user.domain.Address;
import fr.esgi.tp1606.use_cases.user.domain.User;
import fr.esgi.tp1606.use_cases.user.domain.UserId;
import fr.esgi.tp1606.use_cases.user.domain.UserEventSourcedRepository;

public final class CreateUserCommandHandler implements CommandHandler<CreateUser, UserId> {

    private final UserEventSourcedRepository userEventSourcedRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateUserCommandHandler(UserEventSourcedRepository userEventSourcedRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userEventSourcedRepository = userEventSourcedRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public UserId handle(CreateUser createUser) {
        final UserId userId = userEventSourcedRepository.nextIdentity();
        User user = new User(userId, createUser.lastname, createUser.firstname, new Address(createUser.address.city));
        userEventSourcedRepository.add(user);
        eventEventDispatcher.dispatch(new CreateUserApplicationEvent(userId));
        return userId;
    }
}
