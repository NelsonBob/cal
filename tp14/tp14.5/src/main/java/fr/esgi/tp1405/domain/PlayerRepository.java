package fr.esgi.tp1405.domain;

public interface PlayerRepository {
    void add(Player player);

    Player findById(PlayerId id);
}
