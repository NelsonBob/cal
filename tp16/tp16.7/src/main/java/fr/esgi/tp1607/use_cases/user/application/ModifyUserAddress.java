package fr.esgi.tp1607.use_cases.user.application;

import fr.esgi.tp1607.kernel.Command;
import fr.esgi.tp1607.use_cases.user.exposition.AddressDTO;

public class ModifyUserAddress implements Command {

    public final int userId;
    public final AddressDTO address;

    public ModifyUserAddress(int userId, AddressDTO address) {
        this.userId = userId;
        this.address = address;
    }
}
