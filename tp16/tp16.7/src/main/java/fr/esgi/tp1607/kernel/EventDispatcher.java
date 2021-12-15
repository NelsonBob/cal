package fr.esgi.tp1607.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
