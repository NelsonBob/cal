package fr.esgi.tp1605.kernel;

@SuppressWarnings("all")
public interface Entity<VOID extends ValueObjectID> {
    VOID id();
}
