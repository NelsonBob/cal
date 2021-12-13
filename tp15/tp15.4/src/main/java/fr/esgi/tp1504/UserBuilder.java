package fr.esgi.tp1504;

public class UserBuilder {

    private String firstname;
    private String lastname;
    private AddressBuilder addressBuilder;

    public UserBuilder() {
        this.addressBuilder = new AddressBuilder();
    }

    public UserBuilder withFirstName(String firstnameValue) {
        this.firstname = firstnameValue;
        return this;
    }

    public UserBuilder withLastName(String lastnameValue) {
        this.lastname = lastnameValue;
        return this;
    }

    public AddressBuilder withAddress() {
        return addressBuilder;
    }

    public User build() {
        return new User(firstname, lastname, new Address(addressBuilder.city, addressBuilder.country));
    }

    class AddressBuilder {
        private String city;
        private String country;

        AddressBuilder city(String cityValue) {
            AddressBuilder addressBuilder = new AddressBuilder();
            addressBuilder.city = cityValue;
            addressBuilder.country = country;
            return addressBuilder;
        }

        AddressBuilder country(String countryValue) {
            AddressBuilder addressBuilder = new AddressBuilder();
            addressBuilder.city = city;
            addressBuilder.country = countryValue;
            return addressBuilder;
        }

        UserBuilder end() {
            UserBuilder.this.addressBuilder = this;
            return UserBuilder.this;
        }
    }
}
