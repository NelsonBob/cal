package fr.esgi.tp1607.kernel;

@SuppressWarnings("all")
public interface Entity<VOID extends ValueObjectID> {
    VOID id();
}
