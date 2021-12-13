package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.use_cases.user.domain.UserId;

@SuppressWarnings("all")
public class UserDTO {

    public final UserId id;
    public final String lastname;
    public final String firstname;
    public AddressDTO address;

    public UserDTO(UserId id, String lastname, String firstname, AddressDTO address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address=" + address +
                '}';
    }
}
