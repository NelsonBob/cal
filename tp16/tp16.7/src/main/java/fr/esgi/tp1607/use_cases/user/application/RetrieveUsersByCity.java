package fr.esgi.tp1607.use_cases.user.application;

import fr.esgi.tp1607.kernel.Query;

public class RetrieveUsersByCity implements Query {
    public final String city;

    public RetrieveUsersByCity(String city) {
        this.city = city;
    }
}
