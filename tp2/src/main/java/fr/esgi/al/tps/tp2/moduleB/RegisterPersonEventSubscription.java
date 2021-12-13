package fr.esgi.al.tps.tp2.moduleB;


import fr.esgi.al.tps.tp2.common.RegisteredPersonEvent;
import fr.esgi.al.tps.tp2.event.Subscriber;

public class RegisterPersonEventSubscription implements Subscriber<RegisteredPersonEvent> {

    private final PersonMailSender mailSender;

    public RegisterPersonEventSubscription(PersonMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void accept(RegisteredPersonEvent event) {
        var person = event.getPerson();
        mailSender.sendMail(person);
    }
}
