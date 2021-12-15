package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.QueryHandler;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import fr.esgi.tp1605.use_cases.user.exposition.AddressDTO;
import fr.esgi.tp1605.use_cases.user.exposition.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveUsersHandler implements QueryHandler<RetrieveUsers, List<UserDTO>> {

    private final UserRepository userRepository;

    public RetrieveUsersHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> handle(RetrieveUsers query) {
        return userRepository.findAll()
                .stream()
                .map(user ->
                        new UserDTO(user.getId(), user.getLastname(),
                                user.getFirstname(), new AddressDTO(user.getAddress().getCity())))
                .collect(Collectors.toList());
    }
}
