package fr.esgi.tp5;

import java.util.UUID;

interface UserRepository {
    void save(User user);

    User byId(UserId userId);

    default UserId nextId() {
        return UserId.fromUUID(UUID.randomUUID());
    }
}
