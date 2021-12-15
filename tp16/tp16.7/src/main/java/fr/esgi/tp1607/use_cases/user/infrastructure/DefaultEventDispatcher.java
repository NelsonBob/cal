package fr.esgi.tp1607.use_cases.user.infrastructure;

import fr.esgi.tp1607.kernel.Event;
import fr.esgi.tp1607.kernel.EventDispatcher;
import fr.esgi.tp1607.kernel.EventListener;

import java.util.List;
import java.util.Map;

public class DefaultEventDispatcher<E extends Event> implements EventDispatcher<E> {

    private final Map<Class<E>, List<EventListener<E>>> eventListenersMap;

    public DefaultEventDispatcher(Map<Class<E>, List<EventListener<E>>> eventListenersMap) {
        this.eventListenersMap = eventListenersMap;
    }

    @Override
    public void dispatch(E event) {
        final List<EventListener<E>> eventListeners = eventListenersMap.get(event.getClass());
        if (eventListeners != null) {
            eventListeners.forEach(eEventListener -> eEventListener.listenTo(event));
        }
    }
}
