package fr.esgi.tp8;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        myObject.setProperty(new MyObjectProperty());

        final Optional<MyObjectProperty> property = myObject.getProperty();
        if (property.isPresent()) {
            System.out.println("Property is present.");
        }
    }
}
