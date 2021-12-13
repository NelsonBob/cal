package fr.esgi.tp1601.domain;

public interface UserRepository {

    UserId nextIdentity();

    User findById(UserId id);

    void add(User user);

    void delete(UserId userId);
}
