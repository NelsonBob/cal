package fr.esgi.demo.cours.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new MySQLUserRepository();
    }
}
