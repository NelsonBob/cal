package fr.esgi.tp1605.use_cases.user.infrastructure;

import fr.esgi.tp1605.kernel.NoSuchEntityException;
import fr.esgi.tp1605.use_cases.user.domain.User;
import fr.esgi.tp1605.use_cases.user.domain.UserId;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySQLUserRepository implements UserRepository {
    @Override
    public UserId nextIdentity() {
        return null;
    }

    @Override
    public User findById(UserId id) throws NoSuchEntityException {
        return null;
    }

    @Override
    public void add(User entity) {

    }

    @Override
    public void delete(UserId id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findByCity(String city) {
        return null;
    }
}
