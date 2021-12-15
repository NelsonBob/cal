package fr.esgi.tp1607.use_cases.user.application;

import fr.esgi.tp1607.kernel.QueryHandler;
import fr.esgi.tp1607.use_cases.user.domain.UserRepository;
import fr.esgi.tp1607.use_cases.user.exposition.AddressDTO;
import fr.esgi.tp1607.use_cases.user.exposition.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveUsersByCityHandler implements QueryHandler<RetrieveUsersByCity, List<UserDTO>> {

    private final UserRepository userRepository;

    public RetrieveUsersByCityHandler(UserRepository userRepository) {
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
