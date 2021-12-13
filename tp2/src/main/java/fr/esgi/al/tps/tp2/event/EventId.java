package fr.esgi.al.tps.tp2.event;

import java.util.UUID;

public class EventId {

    private final String value;

    private EventId(String value) {
        this.value = value;
    }

    public static EventId create() {
        return new EventId(UUID.randomUUID().toString());
    }
}
