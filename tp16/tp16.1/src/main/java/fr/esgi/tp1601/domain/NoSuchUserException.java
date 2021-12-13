package fr.esgi.tp1601.domain;

public final class NoSuchUserException extends RuntimeException {

    private NoSuchUserException(String message) {
        super(message);
    }

    public static NoSuchUserException withId(UserId id) {
        return new NoSuchUserException(String.format("No user found with ID %d.", id.getValue()));
    }
}
