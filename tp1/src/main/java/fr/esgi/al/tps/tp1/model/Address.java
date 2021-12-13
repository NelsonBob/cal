package fr.esgi.al.tps.tp1.model;

import java.util.Objects;

public final class Address {

    private final int number;
    private final String street;
    private final String city;

    private Address(int number, String street, String city) {
        this.number = number;
        this.street = Objects.requireNonNull(street);
        this.city = Objects.requireNonNull(city);
    }

    public static Address of(int number, String street, String city) {
        return new Address(number, street, city);
    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
}
