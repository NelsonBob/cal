package fr.esgi.tp1601.domain;

import java.util.Objects;

public final class User {

    private final UserId id;
    private final String lastname;
    private final String firstname;
    private String password;

    public User(UserId id, String lastname, String firstname, String password) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
    }

    public UserId getId() {
        return id;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, password);
    }
}
