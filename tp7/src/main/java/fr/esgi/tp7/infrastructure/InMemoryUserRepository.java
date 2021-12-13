package fr.esgi.tp7.infrastructure;

import fr.esgi.tp7.domain.User;
import fr.esgi.tp7.domain.UserId;
import fr.esgi.tp7.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<UserId, User> data = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        data.put(user.getUserId(), user);
    }

    @Override
    public User byId(UserId userId) {
        final User user = data.get(userId);
        if (user == null) {
            throw new RuntimeException("No user for " + userId.getValue());
        }
        return user;
    }

    @Override
    public UserId nextIdentity() {
        return UserId.of(counter.incrementAndGet());
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(data.values());
    }
}
