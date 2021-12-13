package fr.esgi.tp5;

import java.util.UUID;

final class UserId {

    private final String value;

    private UserId(String value) {
        this.value = value;
    }

    public static UserId fromUUID(UUID uuid) {
        return new UserId(uuid.toString());
    }

    public static UserId of(String value) {
        return new UserId(value);
    }

    public String getValue() {
        return value;
    }
}
