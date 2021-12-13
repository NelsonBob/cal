package fr.esgi.tp1302;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TestPackage {

    @Test
    void changeState() {

        final LocalDateTime expectedLocalDateTime = LocalDateTime.of(2021, 11, 1, 12, 34);
        Package aPackage = new Package(PackageId.of(1), expectedLocalDateTime, State.of("PREPARED"));

        aPackage.changeState(State.of("SENT"));
        aPackage.changeState(State.of("IN_TRANSIT"));
        aPackage.changeState(State.of("ARRIVED_INTO_A"));
        aPackage.changeState(State.of("ARRIVED_INTO_B"));
        aPackage.changeState(State.of("DELIVERED"));

        assertEquals(1, aPackage.getId().value());
        assertEquals(expectedLocalDateTime, aPackage.getCreationDate());
        assertEquals(
                Stream.of("PREPARED", "SENT", "IN_TRANSIT", "ARRIVED_INTO_A", "ARRIVED_INTO_B", "DELIVERED")
                        .map(State::of)
                        .collect(Collectors.toList()),
                aPackage.getHistory().getStates());
    }
}
