package fr.esgi.tp1607.use_cases.user.exposition;

public class AddressResponse {
    public String city;

    public AddressResponse(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "AddressDTO{" +
                "city='" + city + '\'' +
                '}';
    }
}
