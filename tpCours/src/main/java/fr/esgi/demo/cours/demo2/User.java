package fr.esgi.demo.cours.demo2;

import java.util.Objects;

/**
 * Value Object
 **/
final class User {

    private final Password password;

    public User(Password password) {
        this.password = password;
    }

    public User withNewPassword(Password password) {
        return new User(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
