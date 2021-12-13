package fr.esgi.tp1301;

import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("unused")
final class Package {

    private final PackageId id;
    private final LocalDateTime creationDate;
    private State state;

    public Package(PackageId id, LocalDateTime creationDate, State initialState) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(creationDate);
        Objects.requireNonNull(initialState);
        this.id = id;
        this.creationDate = creationDate;
        this.state = initialState;
    }

    public void changeState(State state) {
        Objects.requireNonNull(state);
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return id.equals(aPackage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
