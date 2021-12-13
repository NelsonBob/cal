package fr.esgi.tp1405;

import fr.esgi.tp1405.domain.Player;
import fr.esgi.tp1405.domain.PlayerId;
import fr.esgi.tp1405.domain.PlayerRepository;
import fr.esgi.tp1405.domain.Position;
import fr.esgi.tp1405.infrastructure.InMemoryPlayerRepository;
import fr.esgi.tp1405.application.PlayerService;

public class Main {

    public static void main(String[] args) {
        PlayerRepository playerRepository = new InMemoryPlayerRepository();
        PlayerService playerService = new PlayerService(playerRepository);

        PlayerId playerId = PlayerId.of("1");
        final Player player = Player.create(playerId, new Position(10, 20));

        //--Make business
        //.....

        player.moveLeft(4);
        player.moveLeft(1);
        playerService.add(player);
        //.....

        System.out.println("Current position:" + playerService.currentPosition(playerId));

    }
}
