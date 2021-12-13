package fr.esgi.tp1606.use_cases.user.application;

import fr.esgi.tp1606.kernel.ApplicationEvent;
import fr.esgi.tp1606.use_cases.user.domain.UserId;

public class CreateUserApplicationEvent implements ApplicationEvent {
    private final UserId userId;

    public CreateUserApplicationEvent(UserId userId) {
        this.userId = userId;
    }
}
