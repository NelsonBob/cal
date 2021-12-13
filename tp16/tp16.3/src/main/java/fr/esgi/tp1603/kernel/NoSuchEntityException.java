package fr.esgi.tp1603.kernel;

import fr.esgi.tp1603.use_cases.user.domain.UserId;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static <VOID extends ValueObjectID> NoSuchEntityException withId(VOID id) {
        return new NoSuchEntityException(String.format("No entity found with ID %s.", id.getValue()));
    }
}
