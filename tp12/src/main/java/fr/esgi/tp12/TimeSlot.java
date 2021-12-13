package fr.esgi.tp12;

import java.time.LocalDate;
import java.util.Objects;

final class TimeSlot {

    private final LocalDate date;
    private final WindowedPeriod windowedPeriod;

    public TimeSlot(LocalDate date, int startHour, int endHour) {
        this.date = date;
        this.windowedPeriod = new WindowedPeriod(startHour, endHour);
    }

    public WindowedPeriod windowedPeriod() {
        return windowedPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(date, timeSlot.date) && Objects.equals(windowedPeriod, timeSlot.windowedPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, windowedPeriod);
    }
}
