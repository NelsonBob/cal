package fr.esgi.tp1606.use_cases.user.domain;

import fr.esgi.tp1606.kernel.DomainEvent;

public class CreateUserEvent implements DomainEvent {

    private final UserId id;
    private final String lastname;
    private final String firstname;
    private final Address address;

    public CreateUserEvent(UserId id, String lastname, String firstname, Address address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    public UserId getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Address getAddress() {
        return address;
    }
}
