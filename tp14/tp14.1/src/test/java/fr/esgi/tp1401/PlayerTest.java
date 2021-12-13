package fr.esgi.tp1401;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void moveLeft() {
        Player player = new Player(new Position(10, 20));
        player.moveLeft(4);
        assertEquals(List.of(new PlayerMoved(new Position(6, 20))), player.recordedEvents());
    }

    @Test
    void moveLeftWith2Events() {
        Player player = new Player(new Position(10, 20));
        player.moveLeft(4);
        player.moveLeft(1);
        assertEquals(
                List.of(new PlayerMoved(new Position(6, 20)), new PlayerMoved(new Position(5, 20))),
                player.recordedEvents());
    }
}
