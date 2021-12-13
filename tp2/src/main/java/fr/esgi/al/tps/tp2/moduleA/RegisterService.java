package fr.esgi.al.tps.tp2.moduleA;

import fr.esgi.al.tps.tp2.common.Person;
import fr.esgi.al.tps.tp2.common.RegisteredPersonEvent;
import fr.esgi.al.tps.tp2.event.Event;
import fr.esgi.al.tps.tp2.event.EventBus;

public class RegisterService {

    private final EventBus<Event> eventBus;

    public RegisterService(EventBus<Event> eventBus) {
        this.eventBus = eventBus;
    }

    public void register(Person person) {
        System.out.println("Registering " + person);
        //....
        eventBus.send(RegisteredPersonEvent.withPerson(person));
    }
}
