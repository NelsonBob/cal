package fr.esgi.tp1602.use_cases.user.infrastructure;

import fr.esgi.tp1602.use_cases.user.domain.User;
import fr.esgi.tp1602.use_cases.user.domain.UserId;
import fr.esgi.tp1602.use_cases.user.domain.UserRepository;
import fr.esgi.tp1602.kernel.NoSuchEntityException;

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
            throw NoSuchEntityException.withId(id);
        }
        return user;
    }

    @Override
    public void add(User user) {
        data.put(user.getId(), user);
    }

    @Override
    public void delete(UserId id) {
        data.remove(id);
    }
}
