package fr.esgi.tp5;

import java.util.Objects;

final class User {

    private final UserId userId;
    private final String lastname;
    private final String firstname;
    private String password;

    private User(UserId userId, String lastname, String firstname, String password) {
        this.userId = Objects.requireNonNull(userId);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.password = Objects.requireNonNull(password);
    }

    static User of(UserId userId, String lastname, String firstname, String password) {
        return new User(userId, lastname, firstname, password);
    }

    UserId getUserId() {
        return userId;
    }

    void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
