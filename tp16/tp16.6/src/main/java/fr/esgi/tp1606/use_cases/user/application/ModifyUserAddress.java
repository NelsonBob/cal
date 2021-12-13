package fr.esgi.tp1606.use_cases.user.application;

import fr.esgi.tp1606.kernel.Command;

public class ModifyUserAddress implements Command {

    public final int userId;
    public final AddressDTO address;

    public ModifyUserAddress(int userId, AddressDTO address) {
        this.userId = userId;
        this.address = address;
    }
}
