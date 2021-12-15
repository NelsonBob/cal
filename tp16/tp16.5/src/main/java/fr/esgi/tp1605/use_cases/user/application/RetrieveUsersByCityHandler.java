package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.QueryHandler;
import fr.esgi.tp1605.use_cases.user.domain.User;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;

import java.util.List;

public class RetrieveUsersByCityHandler implements QueryHandler<RetrieveUsersByCity, List<User>> {

    private final UserRepository userRepository;

    public RetrieveUsersByCityHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveUsersByCity query) {
        final List<User> users = userRepository.findByCity(query.city);
        if (users == null || users.isEmpty()) {
            throw new NoSuchCityException();
        }
        return users;

    }
}
