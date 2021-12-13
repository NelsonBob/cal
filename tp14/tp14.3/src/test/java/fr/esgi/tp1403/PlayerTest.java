package fr.esgi.tp1403;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void initialPosition() {
        Player player = new Player(10, 20);
        assertEquals(List.of(new PlayerTookInitialPosition(10, 20)), player.recordedEvents());
    }

    @Test
    void moveLeft() {
        Player player = new Player(10, 20);
        player.moveLeft(4);
        assertContains(new PlayerLeftMoved(4), player.recordedEvents());
    }

    private void assertContains(Event event, List<Event> recordedEvents) {
        assertTrue(recordedEvents.contains(event));
    }
}
