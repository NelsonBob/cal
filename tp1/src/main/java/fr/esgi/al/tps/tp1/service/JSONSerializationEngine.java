package fr.esgi.al.tps.tp1.service;

import com.google.gson.Gson;

import java.util.Objects;

final class JSONSerializationEngine<T> implements SerializationEngine<T> {

    private final Gson gson;

    JSONSerializationEngine(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String apply(T object) {
        Objects.requireNonNull(object);
        return gson.toJson(object);
    }
}
