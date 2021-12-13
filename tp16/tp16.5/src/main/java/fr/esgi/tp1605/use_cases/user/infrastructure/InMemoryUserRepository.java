package fr.esgi.tp1605.use_cases.user.infrastructure;

import fr.esgi.tp1605.kernel.NoSuchEntityException;
import fr.esgi.tp1605.use_cases.user.domain.User;
import fr.esgi.tp1605.use_cases.user.domain.UserId;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
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

    @Override
    public List<User> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public List<User> findByCity(String city) {
        return List.copyOf(data.values().stream()
                .filter(user -> user.getAddress().getCity().equals(city)).collect(Collectors.toList()));
    }
}
