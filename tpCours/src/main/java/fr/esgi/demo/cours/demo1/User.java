package fr.esgi.demo.cours.demo1;

final class User {

    private final UserId userId;
    private final String name;

    public User(UserId userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
