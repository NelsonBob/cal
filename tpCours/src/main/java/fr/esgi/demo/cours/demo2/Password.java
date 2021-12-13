package fr.esgi.demo.cours.demo2;

import java.util.Objects;

/**
 * Value Object
 **/
final class Password {

    private final String value;

    public Password(String value) {
        Objects.requireNonNull(value);
        if (!value.contains("#")) {
            throw new IllegalArgumentException("A password must contain at least a '#' char.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
