package fr.esgi.tp1504;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                new UserBuilder()
                        .withLastName("BOISSINOT")
                        .withFirstName("GREGORY")
                        .withAddress().city("ALFRORTVILLE").country("FRANCE").end()
                        .build());
    }
}
