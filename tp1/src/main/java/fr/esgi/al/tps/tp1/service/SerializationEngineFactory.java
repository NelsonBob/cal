package fr.esgi.al.tps.tp1.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

public final class SerializationEngineFactory {
    private SerializationEngineFactory() {
        throw new AssertionError();
    }

    public static <T> SerializationEngine<T> withJSONSerialization(Class<T> classz, TypeAdapter<T> typeAdapter) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(classz, typeAdapter)
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();
        return new JSONSerializationEngine<>(gson);
    }
}
