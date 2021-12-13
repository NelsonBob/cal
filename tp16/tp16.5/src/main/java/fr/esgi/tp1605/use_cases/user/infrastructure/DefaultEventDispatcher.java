package fr.esgi.tp1605.use_cases.user.infrastructure;

import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;

public class DefaultEventDispatcher implements EventDispatcher<Event> {
    @Override
    public void dispatch(Event event) {
        System.out.println("Dispatching Event " + event.getClass().getName());
    }
}
