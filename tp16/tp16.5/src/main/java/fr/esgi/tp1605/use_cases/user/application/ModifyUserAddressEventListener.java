package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.EventListener;

public class ModifyUserAddressEventListener implements EventListener<ModifyUserAddressEvent> {
    @Override
    public void listenTo(ModifyUserAddressEvent event) {
        System.out.println("Listening ModifyUserAddressEvent.");
    }
}
