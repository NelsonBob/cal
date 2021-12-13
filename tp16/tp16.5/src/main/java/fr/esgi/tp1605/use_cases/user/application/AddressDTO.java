package fr.esgi.tp1605.use_cases.user.application;

public class AddressDTO {
    public final String city;

    public AddressDTO(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "city='" + city + '\'' +
                '}';
    }
}
