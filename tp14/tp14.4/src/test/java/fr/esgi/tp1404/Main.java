package fr.esgi.tp1404;

import fr.esgi.tp1404.domain.Player;
import fr.esgi.tp1404.domain.PlayerId;
import fr.esgi.tp1404.domain.PlayerRepository;
import fr.esgi.tp1404.infrastructure.InMemoryPlayerRepository;
import fr.esgi.tp1404.service.PlayerService;

public class Main {

    public static void main(String[] args) {
        PlayerRepository playerRepository = new InMemoryPlayerRepository();
        PlayerService playerService = new PlayerService(playerRepository);

        PlayerId playerId = PlayerId.of("1");
        final Player player = Player.create(playerId, 10, 20);

        //--Make business
        //.....
        player.moveLeft(4);
        player.moveLeft(1);
        playerService.add(player);
        //.....

        System.out.println("Current position:" + playerService.currentPosition(playerId));

    }
}
