package fr.esgi.tp1601.application;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateUser {

    public final String lastname;
    public final String firstname;
    public final String password;

    public CreateUser(String lastname, String firstname, String password) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
    }
}
