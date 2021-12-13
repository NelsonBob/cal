package fr.esgi.tp1406.domain;

public final class Player {

    private final PlayerId playerId;
    private Position position;

    public Player(PlayerId playerId, Position position) {
        this.playerId = playerId;
        this.position = position;
    }

    public void moveLeft(int steps) {
        var nextPosition = this.position.toTheLeft(steps);
        this.position = nextPosition;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Position getPosition() {
        return position;
    }
}
