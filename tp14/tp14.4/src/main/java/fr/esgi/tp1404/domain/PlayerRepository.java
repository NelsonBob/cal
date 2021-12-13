package fr.esgi.tp1404.domain;

public interface PlayerRepository {
    void add(Player player);

    Player findById(PlayerId id);
}
