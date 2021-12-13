package fr.esgi.tp1606.use_cases.user.domain;

import fr.esgi.tp1606.kernel.EventSourcedRepository;
import fr.esgi.tp1606.kernel.Repository;

import java.util.List;

public interface UserEventSourcedRepository extends EventSourcedRepository<UserId, User> {
    List<User> findAll();
}
