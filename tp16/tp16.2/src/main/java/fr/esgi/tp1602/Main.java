package fr.esgi.tp1602;

import fr.esgi.tp1602.use_cases.user.application.*;
import fr.esgi.tp1602.use_cases.user.domain.UserId;
import fr.esgi.tp1602.use_cases.user.infrastructure.InMemoryUserRepository;

public class Main {

    public static void main(String[] args) {
        final InMemoryUserRepository userRepository = new InMemoryUserRepository();
        CreateUserCommandHandler userCommandHandler = new CreateUserCommandHandler(userRepository);
        CreateUser createUser = new CreateUser("BOISSINOT", "GREGORY", new AddressDTO("PARIS"));

        final UserId userId = userCommandHandler.handle(createUser);
        ModifyUserAddressCommandHandler modifyUserAddressCommandHandler = new ModifyUserAddressCommandHandler(userRepository);
        modifyUserAddressCommandHandler.handle(new ModifyUserAddress(userId.getIntValue(), new AddressDTO("ALFORTVILLE")));
        System.out.println(userRepository.findById(userId));


    }
}
