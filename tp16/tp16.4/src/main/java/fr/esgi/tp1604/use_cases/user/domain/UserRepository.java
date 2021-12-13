package fr.esgi.tp1604.use_cases.user.domain;

import fr.esgi.tp1604.kernel.Repository;

import java.util.List;

public interface UserRepository extends Repository<UserId, User> {
    List<User> findAll();

    List<User> findByCity(String city);
}
