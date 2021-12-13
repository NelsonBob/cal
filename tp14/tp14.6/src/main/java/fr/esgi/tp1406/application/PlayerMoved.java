package fr.esgi.tp1406.application;

import fr.esgi.tp1406.domain.Position;
import fr.esgi.tp1406.kernel.ApplicationEvent;

import java.util.Objects;

public final class PlayerMoved implements ApplicationEvent {

    private final Position position;

    public PlayerMoved(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerMoved that = (PlayerMoved) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
