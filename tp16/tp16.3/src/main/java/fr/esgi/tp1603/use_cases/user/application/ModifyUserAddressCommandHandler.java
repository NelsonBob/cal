package fr.esgi.tp1603.use_cases.user.application;

import fr.esgi.tp1603.kernel.CommandHandler;
import fr.esgi.tp1603.use_cases.user.domain.Address;
import fr.esgi.tp1603.use_cases.user.domain.UserId;
import fr.esgi.tp1603.use_cases.user.domain.UserRepository;

public class ModifyUserAddressCommandHandler implements CommandHandler<ModifyUserAddress, Void> {

    private final UserRepository userRepository;

    public ModifyUserAddressCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Void handle(ModifyUserAddress command) {
        var id = new UserId(command.userId);
        var user = userRepository.findById(id);
        var address = new Address(command.address.city);
        user.changeAddress(address);
        userRepository.add(user);
        return null;
    }
}
