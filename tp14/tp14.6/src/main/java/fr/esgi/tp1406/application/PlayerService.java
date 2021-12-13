package fr.esgi.tp1406.application;

import fr.esgi.tp1406.domain.Player;
import fr.esgi.tp1406.domain.PlayerId;
import fr.esgi.tp1406.domain.PlayerRepository;
import fr.esgi.tp1406.kernel.ApplicationEvent;
import fr.esgi.tp1406.kernel.EventBus;

public class PlayerService {

    private final PlayerRepository playerRepository;
    private final EventBus<ApplicationEvent> eventBus;

    public PlayerService(PlayerRepository playerRepository, EventBus<ApplicationEvent> eventBus) {
        this.playerRepository = playerRepository;
        this.eventBus = eventBus;
    }

    public void create(Player player) {
        this.playerRepository.add(player);
        this.eventBus.publish(new PlayerTookInitialPosition(player.getPosition()));
    }

    public void moveLeft(PlayerId playerId, int steps) {
        final Player player = this.playerRepository.findById(playerId);
        player.moveLeft(steps);
        this.playerRepository.add(player);
        this.eventBus.publish(new PlayerMoved(player.getPosition()));
    }
}
