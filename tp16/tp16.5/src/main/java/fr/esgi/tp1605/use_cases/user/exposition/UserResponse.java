package fr.esgi.tp1605.use_cases.user.exposition;

@SuppressWarnings("all")
public class UserResponse {

    public String id;

    //no lastname explicitly

    public String firstname;
    public AddressResponse address;

    public UserResponse(String id, String firstname, AddressResponse address) {
        this.id = id;
        this.firstname = firstname;
        this.address = address;
    }

    public UserResponse() {
    }

    public void setId(String id) {
        this.id = id;
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
                ", firstname='" + firstname + '\'' +
                ", address=" + address +
                '}';
    }
}
