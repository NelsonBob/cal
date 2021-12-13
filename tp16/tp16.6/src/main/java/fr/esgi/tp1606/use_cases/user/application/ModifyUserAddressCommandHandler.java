package fr.esgi.tp1606.use_cases.user.application;

import fr.esgi.tp1606.kernel.CommandHandler;
import fr.esgi.tp1606.kernel.Event;
import fr.esgi.tp1606.kernel.EventDispatcher;
import fr.esgi.tp1606.use_cases.user.domain.Address;
import fr.esgi.tp1606.use_cases.user.domain.UserId;
import fr.esgi.tp1606.use_cases.user.domain.UserEventSourcedRepository;

public class ModifyUserAddressCommandHandler implements CommandHandler<ModifyUserAddress, Void> {

    private final UserEventSourcedRepository userEventSourcedRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyUserAddressCommandHandler(UserEventSourcedRepository userEventSourcedRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userEventSourcedRepository = userEventSourcedRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(ModifyUserAddress command) {
        var userId = new UserId(command.userId);
        var user = userEventSourcedRepository.findById(userId);
        var address = new Address(command.address.city);
        user.changeAddress(address);
        userEventSourcedRepository.add(user);
        eventEventDispatcher.dispatch(new ModifyUserAddressApplicationEvent(userId));
        return null;
    }
}
