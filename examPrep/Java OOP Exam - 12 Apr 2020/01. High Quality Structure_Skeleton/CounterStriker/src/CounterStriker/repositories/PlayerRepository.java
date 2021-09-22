package CounterStriker.repositories;


import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;
import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {

    private List<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.models;
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        if (models.stream().noneMatch(g -> g.getUsername().equals(player.getUsername()))) {
            this.models.add(player);
        }
    }

    @Override
    public boolean remove(Player player) {
        return models.remove(player);
    }

    @Override
    public Player findByName(String name) {
        return models.stream().filter(g -> g.getUsername().equals(name)).findFirst().orElse(null);
    }
}
