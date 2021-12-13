package fr.esgi.demo.cours.demo1;

import java.util.Objects;

public class UserId {
    private final String value;

    private UserId(String value) {
        this.value = value;
    }

    public static UserId of(String value) {
        return new UserId(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equals(value, userId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

//    @Override
//    public int hashCode() {
//        return 5;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof UserId)) {
//            return false;
//        }
//
//        final UserId userId = (UserId) obj;
//        return userId.value.equals(value);
//    }
}
