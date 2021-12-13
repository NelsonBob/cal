package fr.esgi.al.tps.tp2.event;

import java.util.List;

public interface EventBus<E extends Event> {
    void send(E event);

    void registerSubscriber(Class<E> classE, List<Subscriber<E>> subscribers);
}
