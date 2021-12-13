package fr.esgi.tp1405.domain;

import java.util.ArrayList;
import java.util.List;

public final class Player {

    private final PlayerId playerId;
    private final List<PlayerEvent> events;
    private Position currentPosition;

    private Player(PlayerId playerId, List<PlayerEvent> events) {
        this.playerId = playerId;
        this.events = events;
        this.currentPosition=Position.initial();
    }

    public static Player create(PlayerId id) {
        return create(id, Position.initial());
    }

    public static Player create(PlayerId id, Position position) {
        List<PlayerEvent> events = new ArrayList<>();
        events.add(new PlayerTookInitialPosition(position.getX(), position.getY()));
        return new Player(id, events);
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public void moveLeft(int steps) {
        this.events.add(new PlayerLeftMoved(steps));
    }

    public List<PlayerEvent> recordedEvents() {
        return events;
    }

    void apply(PlayerTookInitialPosition playerTookInitialPosition) {
        this.currentPosition = new Position(playerTookInitialPosition.getX(), playerTookInitialPosition.getY());
    }

    void apply(PlayerLeftMoved playerLeftMoved) {
        currentPosition = currentPosition.toTheLeft(playerLeftMoved.getSteps());
    }

    public void replay(List<PlayerEvent> events) {
        for (PlayerEvent event : events) {
            if (event instanceof PlayerTookInitialPosition) {
                this.apply((PlayerTookInitialPosition) event);
            }
            if (event instanceof PlayerLeftMoved) {
                this.apply((PlayerLeftMoved) event);
            }
        }
    }

    public Position currentPosition() {
        return this.currentPosition;
    }
}
