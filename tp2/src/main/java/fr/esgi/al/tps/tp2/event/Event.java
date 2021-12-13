package fr.esgi.al.tps.tp2.event;

import java.time.ZonedDateTime;

public interface Event {

    EventId getId();

    ZonedDateTime getOccurredDate();
}
