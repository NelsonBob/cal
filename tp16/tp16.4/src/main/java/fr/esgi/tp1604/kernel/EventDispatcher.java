package fr.esgi.tp1604.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
