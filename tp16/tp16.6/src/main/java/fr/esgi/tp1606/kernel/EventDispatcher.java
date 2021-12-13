package fr.esgi.tp1606.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
