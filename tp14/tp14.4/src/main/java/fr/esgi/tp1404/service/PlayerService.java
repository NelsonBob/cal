package fr.esgi.tp1404.service;

import fr.esgi.tp1404.domain.Player;
import fr.esgi.tp1404.domain.PlayerId;
import fr.esgi.tp1404.domain.PlayerRepository;
import fr.esgi.tp1404.domain.Position;

public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void add(Player player) {
        this.playerRepository.add(player);
    }

    public Position currentPosition(PlayerId playerId) {
        final Player player = playerRepository.findById(playerId);
        return player.currentPosition();
    }
}
