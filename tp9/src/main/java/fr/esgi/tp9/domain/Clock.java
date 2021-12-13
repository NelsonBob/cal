package fr.esgi.tp9.domain;

import java.time.ZonedDateTime;

public interface Clock {
    ZonedDateTime currentTime();
}
