package fr.esgi.tp1605;

import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.user.application.CreateUserCommandHandler;
import fr.esgi.tp1605.use_cases.user.application.ModifyUserAddressCommandHandler;
import fr.esgi.tp1605.use_cases.user.application.RetrieveUsersByCityHandler;
import fr.esgi.tp1605.use_cases.user.application.RetrieveUsersHandler;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import fr.esgi.tp1605.use_cases.user.infrastructure.DefaultEventDispatcher;
import fr.esgi.tp1605.use_cases.user.infrastructure.InMemoryUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        return new DefaultEventDispatcher();
    }

    @Bean
    public CreateUserCommandHandler createUserCommandHandler() {
        return new CreateUserCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public ModifyUserAddressCommandHandler modifyUserAddressCommandHandler() {
        return new ModifyUserAddressCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public RetrieveUsersHandler retrieveUsersHandler() {
        return new RetrieveUsersHandler(userRepository());
    }

    @Bean
    public RetrieveUsersByCityHandler retrieveUsersByCityHandler() {
        return new RetrieveUsersByCityHandler(userRepository());
    }
}
