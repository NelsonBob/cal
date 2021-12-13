package fr.esgi.tp1406.infrastructure;

import fr.esgi.tp1406.domain.NoSuchPlayerException;
import fr.esgi.tp1406.domain.Player;
import fr.esgi.tp1406.domain.PlayerId;
import fr.esgi.tp1406.domain.PlayerRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPlayerRepository implements PlayerRepository {

    private final Map<PlayerId, Player> data = new HashMap<>();

    @Override
    public void add(Player player) {
        data.put(player.getPlayerId(), player);
    }

    @Override
    public Player findById(PlayerId id) {
        final Player player = data.get(id);
        if (player == null) {
            throw new NoSuchPlayerException();
        }
        return player;
    }
}
