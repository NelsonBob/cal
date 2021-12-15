package fr.esgi.tp1607.use_cases.user.application;

import fr.esgi.tp1607.kernel.EventListener;

public class CreateUserEventListener implements EventListener<CreateUserEvent> {
    @Override
    public void listenTo(CreateUserEvent event) {
        System.out.println("listening CreateUserEvent.");
    }
}
