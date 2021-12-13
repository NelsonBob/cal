package fr.esgi.tp1606.use_cases.user.infrastructure;

import fr.esgi.tp1606.kernel.DomainEvent;
import fr.esgi.tp1606.kernel.NoSuchEntityException;
import fr.esgi.tp1606.use_cases.user.domain.User;
import fr.esgi.tp1606.use_cases.user.domain.UserEventSourcedRepository;
import fr.esgi.tp1606.use_cases.user.domain.UserId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryUserRepository implements UserEventSourcedRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<UserId, List<DomainEvent>> data = new ConcurrentHashMap<>();

    @Override
    public UserId nextIdentity() {
        return new UserId(count.incrementAndGet());
    }

    @Override
    public User findById(UserId id) {
        final List<DomainEvent> recordedEvents = data.get(id);
        if (recordedEvents == null) {
            throw NoSuchEntityException.withId(id);
        }
        return User.of(id, recordedEvents);
    }

    @Override
    public void add(User user) {
        final UserId userId = user.id();
        var domainEvents = data.get(userId);
        if (domainEvents == null) {
            domainEvents = new ArrayList<>();
        }
        domainEvents.addAll(user.recordedEvents());
        data.put(user.id(), domainEvents);
    }

    @Override
    public void delete(UserId id) {
        data.remove(id);
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        final Set<Map.Entry<UserId, List<DomainEvent>>> entries = data.entrySet();
        for (Map.Entry<UserId, List<DomainEvent>> entry : entries) {
            result.add(User.of(entry.getKey(), entry.getValue()));
        }
        return result;

    }
}
