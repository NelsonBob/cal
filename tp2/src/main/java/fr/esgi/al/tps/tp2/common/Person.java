package fr.esgi.al.tps.tp2.common;

public class Person {
    private final String lastname;
    private final String firstname;

    private Person(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public static Person of(String lastname, String firstname) {
        return new Person(lastname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
