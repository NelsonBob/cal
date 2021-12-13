package fr.esgi.demo.cours.demo3;

public interface UserRepository {

    User get(String userId);

    void add(User user);
}
