package fr.esgi.tp1406.domain;

public interface PlayerRepository {
    void add(Player player);

    Player findById(PlayerId id);
}
