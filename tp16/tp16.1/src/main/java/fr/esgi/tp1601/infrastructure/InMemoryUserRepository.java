package fr.esgi.tp1601.infrastructure;

import fr.esgi.tp1601.domain.NoSuchUserException;
import fr.esgi.tp1601.domain.User;
import fr.esgi.tp1601.domain.UserId;
import fr.esgi.tp1601.domain.UserRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<UserId, User> data = new ConcurrentHashMap<>();

    @Override
    public UserId nextIdentity() {
        return new UserId(count.incrementAndGet());
    }

    @Override
    public User findById(UserId id) {
        final User user = data.get(id);
        if (user == null) {
            throw NoSuchUserException.withId(id);
        }
        return user;
    }

    @Override
    public void add(User user) {
        data.put(user.getId(), user);
    }

    @Override
    public void delete(UserId userId) {
        data.remove(userId);
    }
}
