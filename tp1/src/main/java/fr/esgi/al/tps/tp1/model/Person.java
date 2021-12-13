package fr.esgi.al.tps.tp1.model;

import java.util.Objects;
import java.util.Optional;

public final class Person {

    private final String lastname;
    private final String firstname;
    private final int age;
    private final Address address;

    private Person(String lastname, String firstname, int age, Address address) {
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        if (age < 1) {
            throw new IllegalStateException("You must provide a valid age value.");
        }
        this.age = age;
        this.address = address;
    }

    public static Person withAddress(String lastname, String firstname, int age, Address address) {
        return new Person(lastname, firstname, age, address);
    }

    public static Person withNoAddress(String lastname, String firstname, int age) {
        return new Person(lastname, firstname, age, null);
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getAge() {
        return age;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}

