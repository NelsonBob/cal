package fr.esgi.tp1501;

import java.util.Objects;

final class AddressBuilder {

    private String city;
    private String country;

    private AddressBuilder() {
    }

    public static AddressBuilder create() {
        return new AddressBuilder();
    }

    public AddressBuilder withCity(String city) {
        AddressBuilder builder = new AddressBuilder();
        builder.city = Objects.requireNonNull(city);
        builder.country = country;
        return builder;
    }

    public AddressBuilder withCountry(String country) {
        AddressBuilder builder = new AddressBuilder();
        builder.city = city;
        builder.country = Objects.requireNonNull(country);
        return builder;
    }

    public Address build() {
        return new DefaultAddress(city, country);
    }
}
