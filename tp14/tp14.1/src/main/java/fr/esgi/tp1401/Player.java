package fr.esgi.tp1401;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class Player {

    private final List<Event> events;
    private Position position;

    public Player(Position initialPosition) {
        this.position = initialPosition;
        this.events = new ArrayList<>();
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
