package fr.esgi.tp1404.domain;

import java.util.Objects;

public final class PlayerTookInitialPosition implements PlayerEvent {

    private final int x;
    private final int y;

    public PlayerTookInitialPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerTookInitialPosition that = (PlayerTookInitialPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
