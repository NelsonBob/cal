package fr.esgi.tp1606;

import fr.esgi.tp1606.kernel.Event;
import fr.esgi.tp1606.kernel.EventDispatcher;
import fr.esgi.tp1606.use_cases.user.application.*;
import fr.esgi.tp1606.use_cases.user.domain.UserId;
import fr.esgi.tp1606.use_cases.user.infrastructure.InMemoryUserRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final InMemoryUserRepository userRepository = new InMemoryUserRepository();

        EventDispatcher<Event> eventEventDispatcher = event -> System.out.println("Dispatching Event " + event.getClass().getName());

        //--1. Create User
        CreateUserCommandHandler userCommandHandler = new CreateUserCommandHandler(userRepository, eventEventDispatcher);
        CreateUser createUser = new CreateUser("BOISSINOT", "GREGORY", new AddressDTO("PARIS"));
        final UserId userId = userCommandHandler.handle(createUser);

        //--2. Modify User Address
        ModifyUserAddressCommandHandler modifyUserAddressCommandHandler = new ModifyUserAddressCommandHandler(userRepository, eventEventDispatcher);
        modifyUserAddressCommandHandler.handle(new ModifyUserAddress(userId.getIntValue(), new AddressDTO("ALFORTVILLE")));

        //--3. Retrieve all users
        RetrieveUsers retrieveUsers = new RetrieveUsers();
        RetrieveUsersHandler retrieveUsersHandler = new RetrieveUsersHandler(userRepository);
        final List<UserDTO> users = retrieveUsersHandler.handle(retrieveUsers);
        users.forEach(System.out::println);
    }
}
