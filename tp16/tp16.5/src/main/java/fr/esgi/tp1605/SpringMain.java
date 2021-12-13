package fr.esgi.tp1605;

import fr.esgi.tp1605.use_cases.user.application.*;
import fr.esgi.tp1605.use_cases.user.domain.UserId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        //--1. Create User
        CreateUserCommandHandler userCommandHandler = applicationContext.getBean(CreateUserCommandHandler.class);
        CreateUser createUser = new CreateUser("BOISSINOT", "GREGORY", new AddressDTO("PARIS"));
        final UserId userId = userCommandHandler.handle(createUser);

        //--2. Modify User Address
        ModifyUserAddressCommandHandler modifyUserAddressCommandHandler = applicationContext.getBean(ModifyUserAddressCommandHandler.class);
        modifyUserAddressCommandHandler.handle(new ModifyUserAddress(userId.getValue(), new AddressDTO("ALFORTVILLE")));

        //--3. Retrieve all users
        RetrieveUsers retrieveUsers = new RetrieveUsers();
        RetrieveUsersHandler retrieveUsersHandler = applicationContext.getBean(RetrieveUsersHandler.class);
        final List<UserDTO> users = retrieveUsersHandler.handle(retrieveUsers);
        users.forEach(System.out::println);

        //--4. Retrieve user with ALFORTVILLE city
        RetrieveUsersByCity retrieveUsersByCity = new RetrieveUsersByCity("ALFORTVILLE");
        RetrieveUsersByCityHandler retrieveUsersByCityHandler = applicationContext.getBean(RetrieveUsersByCityHandler.class);
        final List<UserDTO> searchedUsers = retrieveUsersByCityHandler.handle(retrieveUsersByCity);
        searchedUsers.forEach(System.out::println);
    }
}
