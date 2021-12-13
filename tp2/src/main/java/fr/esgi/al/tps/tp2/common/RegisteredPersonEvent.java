package fr.esgi.al.tps.tp2.common;


import fr.esgi.al.tps.tp2.event.Event;
import fr.esgi.al.tps.tp2.event.EventId;

import java.time.ZonedDateTime;

public class RegisteredPersonEvent implements Event {

    private final EventId eventId;
    private final ZonedDateTime occurredDate;
    private final Person person;

    private RegisteredPersonEvent(EventId eventId, ZonedDateTime occurredDate, Person person) {
        this.eventId = eventId;
        this.occurredDate = occurredDate;
        this.person = person;
    }

    public static RegisteredPersonEvent withPerson(Person person) {
        return new RegisteredPersonEvent(EventId.create(), ZonedDateTime.now(), person);
    }

    @Override
    public EventId getId() {
        return eventId;
    }

    @Override
    public ZonedDateTime getOccurredDate() {
        return occurredDate;
    }

    public EventId getEventId() {
        return eventId;
    }

    public Person getPerson() {
        return person;
    }
}
