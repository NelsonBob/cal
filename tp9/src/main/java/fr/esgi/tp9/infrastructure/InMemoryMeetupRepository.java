package fr.esgi.tp9.infrastructure;

import fr.esgi.tp9.domain.Clock;
import fr.esgi.tp9.domain.Meetup;
import fr.esgi.tp9.domain.MeetupRepository;

import java.util.List;
import java.util.Map;

public class InMemoryMeetupRepository implements MeetupRepository {

    private final Map<Integer/*HOUR*/, List<Meetup>> data;
    private final Clock clock;

    public InMemoryMeetupRepository(Clock clock, Map<Integer, List<Meetup>> data) {
        this.clock = clock;
        this.data = data;
    }

    @Override
    public List<Meetup> findUpcommingMeetups() {
        return data.get(clock.currentTime().getHour());
    }
}
