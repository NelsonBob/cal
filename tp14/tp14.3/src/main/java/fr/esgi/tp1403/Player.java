package fr.esgi.tp1403;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Player {

    private final List<Event> events;

    public Player(int x, int y) {
        this.events = new ArrayList<>();
        this.events.add(new PlayerTookInitialPosition(x, y));
    }

    public void moveLeft(int steps) {
        this.events.add(new PlayerLeftMoved(steps));
    }

    public List<Event> recordedEvents() {
        return Collections.unmodifiableList(events);
    }
}
