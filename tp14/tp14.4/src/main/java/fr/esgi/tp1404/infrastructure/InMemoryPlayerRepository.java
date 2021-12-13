package fr.esgi.tp1404.infrastructure;

import fr.esgi.tp1404.domain.Player;
import fr.esgi.tp1404.domain.PlayerEvent;
import fr.esgi.tp1404.domain.PlayerId;
import fr.esgi.tp1404.domain.PlayerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPlayerRepository implements PlayerRepository {

    private final Map<PlayerId, List<PlayerEvent>> data;

    public InMemoryPlayerRepository() {
        this.data = new HashMap<>();
    }

    @Override
    public void add(Player player) {
        data.put(player.getPlayerId(), player.recordedEvents());
    }

    @Override
    public Player findById(PlayerId id) {
        final List<PlayerEvent> playerEvents = data.get(id);
        if (playerEvents == null) {
            throw new RuntimeException();
        }
        //Rehydrate the player object
        return Player.create(id, playerEvents);
    }
}
