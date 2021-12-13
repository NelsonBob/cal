package fr.esgi.tp1604.use_cases.user.application;

import fr.esgi.tp1604.kernel.CommandHandler;
import fr.esgi.tp1604.kernel.Event;
import fr.esgi.tp1604.kernel.EventDispatcher;
import fr.esgi.tp1604.use_cases.user.domain.Address;
import fr.esgi.tp1604.use_cases.user.domain.UserId;
import fr.esgi.tp1604.use_cases.user.domain.UserRepository;

public class ModifyUserAddressCommandHandler implements CommandHandler<ModifyUserAddress, Void> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyUserAddressCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(ModifyUserAddress command) {
        var userId = new UserId(command.userId);
        var user = userRepository.findById(userId);
        var address = new Address(command.address.city);
        user.changeAddress(address);
        userRepository.add(user);
        eventEventDispatcher.dispatch(new ModifyUserAddressEvent(userId));
        return null;
    }
}
