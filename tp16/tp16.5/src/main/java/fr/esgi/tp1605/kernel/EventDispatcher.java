package fr.esgi.tp1605.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
