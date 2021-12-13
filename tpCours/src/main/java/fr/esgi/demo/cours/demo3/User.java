package fr.esgi.demo.cours.demo3;

public class User {
    private final String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void changePassword(String newPassword) {
        this.password = password;
    }
}
