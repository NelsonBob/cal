package fr.esgi.tp1301;

import java.util.Objects;

final class State {

    private final String name;

    private State(String name) {
        this.name = name;
    }

    public static State of(String name) {
        return new State(name);
    }

    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
