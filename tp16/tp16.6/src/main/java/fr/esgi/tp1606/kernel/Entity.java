package fr.esgi.tp1606.kernel;

import java.util.List;

public interface Entity<VOID extends ValueObjectID> {
    VOID id();
    List<DomainEvent> recordedEvents();
}
