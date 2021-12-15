package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.QueryHandler;
import fr.esgi.tp1605.use_cases.user.domain.User;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveUsersByCityHandler implements QueryHandler<RetrieveUsersByCity, List<User>> {

    private final UserRepository userRepository;

    public RetrieveUsersByCityHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveUsersByCity query) {
        return userRepository.findByCity(query.city)
                .stream()
                .collect(Collectors.toList());

    }
}
