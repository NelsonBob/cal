package fr.esgi.tp9.domain;

import fr.esgi.tp9.infrastructure.InMemoryMeetupRepository;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class MeetupRepositoryTest {

    private final static int TEST_MEETUP_HOUR = 11;

    private final Clock stubClock = () -> ZonedDateTime.of(2021, 10, 27, TEST_MEETUP_HOUR, 30, 50, 0, ZoneId.systemDefault());

    private final Map<Integer, List<Meetup>> testData =
            Collections.singletonMap(TEST_MEETUP_HOUR, List.of(new Meetup(1, TEST_MEETUP_HOUR),
                    new Meetup(2, TEST_MEETUP_HOUR)));
    private final MeetupRepository stubMeetupRepository = new InMemoryMeetupRepository(stubClock, testData);

    @Test
    void findUpcommingMeetups() {
        final List<Meetup> upcommingMeetups = stubMeetupRepository.findUpcommingMeetups();
        assertEquals(2, upcommingMeetups.size());
        for (Meetup upcommingMeetup : upcommingMeetups) {
            final int meetupScheduledAtHour = stubClock.currentTime().getHour();
            assertEquals(meetupScheduledAtHour, upcommingMeetup.getScheduledAtHour());
        }
    }
}
