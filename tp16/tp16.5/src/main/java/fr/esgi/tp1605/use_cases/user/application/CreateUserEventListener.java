package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.EventListener;

public class CreateUserEventListener implements EventListener<CreateUserEvent> {
    @Override
    public void listenTo(CreateUserEvent event) {
        System.out.println("listening CreateUserEvent.");
    }
}
