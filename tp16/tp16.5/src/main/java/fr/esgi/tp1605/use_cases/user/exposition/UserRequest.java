package fr.esgi.tp1605.use_cases.user.exposition;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRequest {

    @NotNull
    public String id;

    @NotNull
    @NotBlank
    public String lastname;

    @NotNull
    @NotBlank
    public String firstname;

    @NotNull
    @NotBlank
    public AddressRequest address;
}
