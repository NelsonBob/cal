package fr.esgi.tp11.withrepository;

import fr.esgi.tp11.Address;
import fr.esgi.tp11.User;

public class Main {

    public static void main(String[] args) {
        //Create user
        Address address = Address.of(1, "ALFORTVILLE");

        User user1 = new User(1, "BOISSINOT", "GREGORY", address, "CHANGEME");

        Users users = new MySQLUsers();

        //Save my user
        users.add(user1);
        users.add(user1);
        users.add(user1);
        users.add(user1);
        users.add(user1);

        //Modify Password
        user1.changePassword("CHANGEPASSWORD");
        users.add(user1);

        //Modify address
        user1.changeAddress(Address.of(1, "PARIS"));
        users.add(user1);

    }
}
