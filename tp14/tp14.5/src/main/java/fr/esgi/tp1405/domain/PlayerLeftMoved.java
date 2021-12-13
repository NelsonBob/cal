package fr.esgi.tp1405.domain;

import java.util.Objects;

final class PlayerLeftMoved implements PlayerEvent {

    private final int steps;

    public PlayerLeftMoved(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerLeftMoved that = (PlayerLeftMoved) o;
        return steps == that.steps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }
}
