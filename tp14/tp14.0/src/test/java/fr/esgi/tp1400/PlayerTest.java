package fr.esgi.tp1400;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void moveLeftWithAccessorMode() {
        Position position = new Position(10, 20);
        Player player = new Player(position);
        player.moveLeft(4);
        assertEquals(new Position(6, 20), player.currentPosition());
    }

    @Test
    void moveLeftWithNoAccessorMode() {
        Position position = new Position(10, 20);
        Player player = new Player(position);
        player.moveLeft(4);
        //Use a new Player object wrapping the expected position object value
        assertEquals(new Player(new Position(6, 20)), player);
    }

    @Test
    void moveLeftWithImmutabilityMode() {
        Position position = new Position(10, 20);
        Player player = new Player(position);
        var currentPosition = player.moveLeftWithImmutabilityMode(4);
        //Can use the returned position object for equality
        assertEquals(new Position(6, 20), currentPosition);
        //Always need to add a test for the player itself
        assertEquals(new Player(currentPosition), player);
    }
}
