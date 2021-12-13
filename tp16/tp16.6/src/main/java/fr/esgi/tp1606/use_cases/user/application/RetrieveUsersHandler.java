package fr.esgi.tp1606.use_cases.user.application;

import fr.esgi.tp1606.kernel.QueryHandler;
import fr.esgi.tp1606.use_cases.user.domain.UserEventSourcedRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveUsersHandler implements QueryHandler<RetrieveUsers, List<UserDTO>> {

    private final UserEventSourcedRepository userEventSourcedRepository;

    public RetrieveUsersHandler(UserEventSourcedRepository userEventSourcedRepository) {
        this.userEventSourcedRepository = userEventSourcedRepository;
    }

    @Override
    public List<UserDTO> handle(RetrieveUsers query) {
        return userEventSourcedRepository.findAll()
                .stream()
                .map(user ->
                        new UserDTO(user.id(), user.getLastname(),
                                user.getFirstname(), new AddressDTO(user.getAddress().getCity())))
                .collect(Collectors.toList());
    }
}
