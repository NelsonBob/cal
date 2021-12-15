package fr.esgi.tp1605.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}
