package fr.esgi.tp1606.use_cases.user.domain;


import fr.esgi.tp1606.kernel.DomainEvent;
import fr.esgi.tp1606.kernel.Entity;

import java.util.ArrayList;
import java.util.List;

public final class User implements Entity<UserId> {

    private final UserId id;
    private final List<DomainEvent> recordedEvents;

    private String lastname;
    private String firstname;
    private Address address;

    private User(UserId id, List<DomainEvent> recordedEvents) {
        this.id = id;
        this.recordedEvents = recordedEvents;
    }

    public static User of(UserId userId, String lastname, String firstname, Address address) {
        final List<DomainEvent> recordedEvents = new ArrayList<>();
        recordedEvents.add(new CreateUserEvent(userId, lastname, firstname, address));
        return new User(userId, recordedEvents);
    }

    public static User of(UserId id, List<DomainEvent> recordedEvents) {
        final User user = new User(id, new ArrayList<>());
        user.replay(recordedEvents);
        return user;
    }

    public void changeAddress(Address address) {
        this.recordedEvents.add(new ModifyUserAddressEvent(address));
    }

    @Override
    public List<DomainEvent> recordedEvents() {
        return recordedEvents;
    }

    private void replay(List<DomainEvent> recordedEvents) {
        for (DomainEvent recordedEvent : recordedEvents) {
            if (recordedEvent instanceof CreateUserEvent) {
                applyEvent((CreateUserEvent) recordedEvent);
            } else if (recordedEvent instanceof ModifyUserAddressEvent) {
                applyEvent((ModifyUserAddressEvent) recordedEvent);
            }
        }
    }

    private void applyEvent(CreateUserEvent createUserEvent) {
        this.lastname = createUserEvent.getLastname();
        this.firstname = createUserEvent.getFirstname();
        this.address = createUserEvent.getAddress();
    }

    private void applyEvent(ModifyUserAddressEvent modifyUserAddressEvent) {
        this.address = modifyUserAddressEvent.getAddress();
    }

    @Override
    public UserId id() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Address getAddress() {
        return address;
    }
}
