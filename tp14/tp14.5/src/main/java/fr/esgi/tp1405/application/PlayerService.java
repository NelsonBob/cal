package fr.esgi.tp1405.application;

import fr.esgi.tp1405.domain.Player;
import fr.esgi.tp1405.domain.PlayerId;
import fr.esgi.tp1405.domain.PlayerRepository;
import fr.esgi.tp1405.domain.Position;

public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void add(Player player) {
        this.playerRepository.add(player);
    }

    public Position currentPosition(PlayerId playerId) {
        var player = playerRepository.findById(playerId);
        return player.currentPosition();
    }
}
