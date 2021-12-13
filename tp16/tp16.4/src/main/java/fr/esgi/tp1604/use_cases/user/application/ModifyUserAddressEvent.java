package fr.esgi.tp1604.use_cases.user.application;

import fr.esgi.tp1604.kernel.ApplicationEvent;
import fr.esgi.tp1604.use_cases.user.domain.UserId;

public class ModifyUserAddressEvent implements ApplicationEvent {
    private final UserId userId;

    public ModifyUserAddressEvent(UserId userId) {
        this.userId = userId;
    }
}
