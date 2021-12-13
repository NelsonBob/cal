package fr.esgi.tp1406.application;

import fr.esgi.tp1406.domain.Player;
import fr.esgi.tp1406.domain.PlayerId;
import fr.esgi.tp1406.domain.PlayerRepository;
import fr.esgi.tp1406.domain.Position;
import fr.esgi.tp1406.infrastructure.InMemoryPlayerRepository;
import fr.esgi.tp1406.kernel.ApplicationEvent;
import fr.esgi.tp1406.kernel.EventBus;
import fr.esgi.tp1406.kernel.SimpleEventBus;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PlayerRepository repository = new InMemoryPlayerRepository();
        EventBus<ApplicationEvent> eventBus = new SimpleEventBus<>();
        eventBus.register(PlayerMoved.class, List.of(
                new PlayerMovedListener1(),
                new PlayerMovedListener2()));

        PlayerService playerService = new PlayerService(repository, eventBus);

        PlayerId playerId1 = PlayerId.of("1");
        Player player1 = new Player(playerId1, new Position(0, 0));
        playerService.create(player1);

        playerService.moveLeft(playerId1, 4);
    }
}
