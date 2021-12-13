package fr.esgi.al.tps.tp2;

import fr.esgi.al.tps.tp2.common.Person;
import fr.esgi.al.tps.tp2.common.RegisteredPersonEvent;
import fr.esgi.al.tps.tp2.event.DefaultEventBus;
import fr.esgi.al.tps.tp2.event.Event;
import fr.esgi.al.tps.tp2.event.EventBus;
import fr.esgi.al.tps.tp2.moduleA.RegisterService;
import fr.esgi.al.tps.tp2.moduleB.PersonMailSender;
import fr.esgi.al.tps.tp2.moduleB.RegisterPersonEventSubscription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    @SuppressWarnings("all")
    public static void main(String[] args) {

        final Map<Class<? extends Event>, List<RegisterPersonEventSubscription>> subscriptionMap = new HashMap<>();
        final List<RegisterPersonEventSubscription> subscribers = List.of(new RegisterPersonEventSubscription(new PersonMailSender()));
        subscriptionMap.put(RegisteredPersonEvent.class, subscribers);

        EventBus<Event> eventBus = new DefaultEventBus(subscriptionMap);

        RegisterService registerService = new RegisterService(eventBus);

        Person person = Person.of("BOISSINOT", "GREGORY");
        registerService.register(person);
    }
}
