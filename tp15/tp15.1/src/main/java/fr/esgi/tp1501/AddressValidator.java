package fr.esgi.tp1501;

import java.util.function.Predicate;

final class AddressValidator implements Predicate<Address> {

    private static final AddressValidator INSTANCE = new AddressValidator();

    public static AddressValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean test(Address address) {
        return true;
    }
}
