package fr.esgi.tp1606.use_cases.user.application;

import fr.esgi.tp1606.kernel.ApplicationEvent;
import fr.esgi.tp1606.use_cases.user.domain.UserId;

public class ModifyUserAddressApplicationEvent implements ApplicationEvent {
    private final UserId userId;

    public ModifyUserAddressApplicationEvent(UserId userId) {
        this.userId = userId;
    }
}
