package fr.esgi.tp1405.domain;

import java.util.Objects;

public final class PlayerId {
    private final String id;

    private PlayerId(String id) {
        this.id = id;
    }

    public static PlayerId of(String id) {
        return new PlayerId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerId playerId = (PlayerId) o;
        return Objects.equals(id, playerId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
