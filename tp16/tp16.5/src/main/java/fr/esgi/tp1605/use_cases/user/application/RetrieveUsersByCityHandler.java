package fr.esgi.tp1605.use_cases.user.application;


import fr.esgi.tp1605.kernel.QueryHandler;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrieveUsersByCityHandler implements QueryHandler<RetrieveUsersByCity, List<UserDTO>> {

    private final UserRepository userRepository;

    private RetrieveUsersByCityHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> handle(RetrieveUsersByCity query) {
        return userRepository.findByCity(query.city)
                .stream()
                .map(user ->
                        new UserDTO(user.getId(), user.getLastname(),
                                user.getFirstname(), new AddressDTO(user.getAddress().getCity())))
                .collect(Collectors.toList());

    }
}
