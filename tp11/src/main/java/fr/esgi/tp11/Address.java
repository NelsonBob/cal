package fr.esgi.tp11;

public class Address {

    private final int id;
    private final String city;

    private Address(int id, String city) {
        this.id = id;
        if (!checkCityPreconditions(city)) {
            throw new IllegalArgumentException("The city must be set.");
        }
        this.city = city;
    }

    public static Address of(int id, String city) {
        Address address = new Address(id, city);
        if (ValidationAddressEngine.getInstance().test(address)) {
            return address;
        }
        throw new IllegalArgumentException("Illegal arguments");
    }

    private boolean checkCityPreconditions(String city) {
        if (city == null) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
