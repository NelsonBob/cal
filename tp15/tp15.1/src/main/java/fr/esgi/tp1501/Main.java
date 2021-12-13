package fr.esgi.tp1501;

final class Main {
    public static void main(String[] args) {

        final AddressBuilder addressBuilder =
                AddressBuilder.create().withCountry("FRANCE");

        Address address1 = addressBuilder
                .withCity("ALFORTVILLE")
                .withCountry("FRANCE")
                .build();

        Address address2 = addressBuilder
                .withCity("SHANGHAI")
                .withCountry("CHINE")
                .build();

        User user = User.create("GREGORY", address2);
        if (!(address1 instanceof NoAddress)) {
            System.out.println(user.getAddress().city());
        }
    }
}
