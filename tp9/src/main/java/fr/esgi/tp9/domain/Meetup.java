package fr.esgi.tp9.domain;

public class Meetup {

    private final int id;
    private final int scheduledAtHour;

    public Meetup(int id, int scheduledAtHour) {
        this.id = id;
        this.scheduledAtHour = scheduledAtHour;
    }

    public int getScheduledAtHour() {
        return scheduledAtHour;
    }
}
