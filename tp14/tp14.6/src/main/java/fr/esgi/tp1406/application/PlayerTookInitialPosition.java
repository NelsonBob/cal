package fr.esgi.tp1406.application;

import fr.esgi.tp1406.domain.Position;
import fr.esgi.tp1406.kernel.ApplicationEvent;

import java.util.Objects;

public final class PlayerTookInitialPosition implements ApplicationEvent {

    private final Position position;

    public PlayerTookInitialPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerTookInitialPosition that = (PlayerTookInitialPosition) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
