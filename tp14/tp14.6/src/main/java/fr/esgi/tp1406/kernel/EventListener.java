package fr.esgi.tp1406.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}
