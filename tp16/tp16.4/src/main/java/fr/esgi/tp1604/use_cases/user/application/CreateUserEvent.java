package fr.esgi.tp1604.use_cases.user.application;

import fr.esgi.tp1604.kernel.ApplicationEvent;
import fr.esgi.tp1604.use_cases.user.domain.UserId;

public class CreateUserEvent implements ApplicationEvent {
    private final UserId userId;

    public CreateUserEvent(UserId userId) {
        this.userId = userId;
    }
}
