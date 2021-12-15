package fr.esgi.tp1607.use_cases.user.application;

import fr.esgi.tp1607.kernel.Command;
import fr.esgi.tp1607.use_cases.user.exposition.AddressResponse;

public class ModifyUserAddress implements Command {

    public final int userId;
    public final AddressResponse address;

    public ModifyUserAddress(int userId, AddressResponse address) {
        this.userId = userId;
        this.address = address;
    }
}
