package fr.esgi.tp1607.use_cases.user.exposition;

@SuppressWarnings("all")
public class UserResponse {

    public String id;
    public String lastname;
    public String firstname;
    public AddressResponse address;

    public UserResponse(String id, String lastname, String firstname, AddressResponse address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    public UserResponse() {
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddress(AddressResponse address) {
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
