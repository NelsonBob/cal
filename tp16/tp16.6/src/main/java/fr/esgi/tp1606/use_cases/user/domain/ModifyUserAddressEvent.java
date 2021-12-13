package fr.esgi.tp1606.use_cases.user.domain;

import fr.esgi.tp1606.kernel.DomainEvent;

public class ModifyUserAddressEvent implements DomainEvent {

    private final Address address;

    public ModifyUserAddressEvent(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
