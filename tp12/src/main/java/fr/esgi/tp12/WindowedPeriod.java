package fr.esgi.tp12;

import java.util.Objects;

final class WindowedPeriod {

    private final int startHour;
    private final int endHour;

    public WindowedPeriod(int startHour, int endHour) {
        checkPreconditions(startHour, endHour);
        this.startHour = startHour;
        this.endHour = endHour;
    }

    private void checkPreconditions(int startHour, int endHour) {
        if (startHour >= endHour) {
            throw new IllegalArgumentException("start hour must be before end hour.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WindowedPeriod that = (WindowedPeriod) o;
        return startHour == that.startHour && endHour == that.endHour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startHour, endHour);
    }
}
