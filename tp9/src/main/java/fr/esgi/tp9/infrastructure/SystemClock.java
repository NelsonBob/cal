package fr.esgi.tp9.infrastructure;

import fr.esgi.tp9.domain.Clock;

import java.time.ZonedDateTime;

public class SystemClock implements Clock {
    @Override
    public ZonedDateTime currentTime() {
        return ZonedDateTime.now();
    }
}
