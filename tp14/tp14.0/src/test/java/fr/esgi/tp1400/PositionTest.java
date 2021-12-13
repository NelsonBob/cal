package fr.esgi.tp1400;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    void toTheLeft() {
        Position position = new Position(10, 20);
        Position nextPosition = position.toTheLeft(4);

        //Equality with object content without getters on Position object
        assertEquals(new Position(6, 20), nextPosition);

        //Test that the initial position is not modified
        assertEquals(new Position(10, 20), position);
    }
}
