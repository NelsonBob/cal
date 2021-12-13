package fr.esgi.tp9.domain;

import java.util.List;

public interface MeetupRepository {
    List<Meetup> findUpcommingMeetups();
}
