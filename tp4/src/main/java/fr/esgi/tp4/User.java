package fr.esgi.tp4;

final class User {

    private final String lastname;
    private final String firstname;

    private User(String lastname, String firtstname) {
        this.lastname = lastname;
        this.firstname = firtstname;
    }

    public static User of(String lastname, String firstname) {
        return new User(lastname, firstname);
    }

    @Override
    public String toString() {
        return "User{" +
                "lastname='" + lastname + '\'' +
                ", firtstname='" + firstname + '\'' +
                '}';
    }
}
