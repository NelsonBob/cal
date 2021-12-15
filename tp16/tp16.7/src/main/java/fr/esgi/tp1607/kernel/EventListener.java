package fr.esgi.tp1607.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}
