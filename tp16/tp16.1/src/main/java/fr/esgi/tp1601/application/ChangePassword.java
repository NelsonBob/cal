package fr.esgi.tp1601.application;

public class ChangePassword {

    public final int userId;
    public final String newPassword;

    public ChangePassword(int userId, String newPassword) {
        this.userId = userId;
        this.newPassword = newPassword;
    }
}
