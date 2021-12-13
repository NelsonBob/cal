package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.Query;

public class RetrieveUsersByCity implements Query {
    public final String city;

    public RetrieveUsersByCity(String city) {
        this.city = city;
    }
}
