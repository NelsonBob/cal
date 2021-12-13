package fr.esgi.tp1501;

final class User {
    private final String firstname;
    private Address address;


    private User(String firstname, Address address) {
        this.firstname = firstname;
        this.address = address;
    }

    public static User create(String firstname) {
        return new User(firstname, new NoAddress());
    }

    public static User create(String firstname, Address address) {
        if (!AddressValidator.getInstance().test(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }
        return new User(firstname, address);
    }

    public Address getAddress() {
        return address;
    }
}
