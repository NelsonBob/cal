package fr.esgi.tp1605.use_cases.user.exposition;

public class AddressRequest {
    public String city;

    public AddressRequest(String city) {
        this.city = city;
    }

    public AddressRequest() {
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "city='" + city + '\'' +
                '}';
    }
}
