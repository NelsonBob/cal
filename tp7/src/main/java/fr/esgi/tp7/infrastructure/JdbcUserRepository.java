package fr.esgi.tp7.infrastructure;

import fr.esgi.tp7.domain.User;
import fr.esgi.tp7.domain.UserId;
import fr.esgi.tp7.domain.UserRepository;

import java.util.List;

public final class JdbcUserRepository implements UserRepository {

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public User byId(UserId userId) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public UserId nextIdentity() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
