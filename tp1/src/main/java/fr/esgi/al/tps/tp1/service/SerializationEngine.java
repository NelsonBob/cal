package fr.esgi.al.tps.tp1.service;

import java.util.function.Function;

public interface SerializationEngine<T> extends Function<T, String> {
}
