package fr.esgi.tp1404.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Player {

    private final PlayerId playerId;
    private final List<PlayerEvent> events;

    private Player(PlayerId playerId, List<PlayerEvent> events) {
        this.playerId = playerId;
        this.events = events;
    }

    public static Player create(PlayerId id, int x, int y) {
        List<PlayerEvent> events = new ArrayList<>();
        events.add(new PlayerTookInitialPosition(x, y));
        return new Player(id, events);
    }

    public static Player create(PlayerId id, List<PlayerEvent> events) {
        return new Player(id, events);
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public void moveLeft(int steps) {
        this.events.add(new PlayerLeftMoved(steps));
    }

    public List<PlayerEvent> recordedEvents() {
        return Collections.unmodifiableList(events);
    }

    public Position currentPosition() {
        Position position = new Position(0,0);
        //replay events
        for (PlayerEvent event : events) {
            if (event instanceof PlayerTookInitialPosition) {
                PlayerTookInitialPosition playerTookInitialPosition = (PlayerTookInitialPosition) event;
                position = new Position(playerTookInitialPosition.getX(), playerTookInitialPosition.getY());
            }

            if (event instanceof PlayerLeftMoved) {
                final PlayerLeftMoved playerLeftMoved = (PlayerLeftMoved) event;
                position = position.toTheLeft(playerLeftMoved.getSteps());
            }
        }
        return position;
    }
}
