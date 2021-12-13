package fr.esgi.demo.cours.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class);
        final UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        System.out.println(userRepository.getClass().getName());
    }
}
