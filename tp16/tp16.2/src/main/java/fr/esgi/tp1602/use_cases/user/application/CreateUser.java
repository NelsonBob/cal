package fr.esgi.tp1602.use_cases.user.application;

import fr.esgi.tp1602.kernel.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateUser implements Command {

    public final String lastname;
    public final String firstname;
    public final AddressDTO address;

    public CreateUser(String lastname, String firstname, AddressDTO address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }
}
