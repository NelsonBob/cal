package fr.esgi.tp1402;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class Player {

    private final List<Event> events;
    private Position position;

    private Player(Position position, List<Event> events) {
        this.position = position;
        this.events = events;
    }

    public static Player create(Position initialPosition) {
        List<Event> events = new ArrayList<>();
        events.add(new PlayerTookInitialPosition(initialPosition));
        return new Player(initialPosition, events);
    }

    public void moveLeft(int steps) {
        var nextPosition = this.position.toTheLeft(steps);
        this.position = nextPosition;
        this.events.add(new PlayerMoved(nextPosition));
    }

    public List<Event> recordedEvents() {
        return Collections.unmodifiableList(events);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
