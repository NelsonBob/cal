package fr.esgi.tp1403;

import java.util.Objects;

public class PlayerTookInitialPosition implements Event {

    private final int x;
    private final int y;

    public PlayerTookInitialPosition(int x, int y) {
        this.x = x;
        this.y = y;
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
