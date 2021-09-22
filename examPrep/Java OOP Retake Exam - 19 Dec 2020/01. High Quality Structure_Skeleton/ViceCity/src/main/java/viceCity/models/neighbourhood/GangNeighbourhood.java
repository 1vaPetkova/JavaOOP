package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.*;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> gunRepository = mainPlayer.getGunRepository();
        Deque<Player> players = new ArrayDeque<>(civilPlayers);
        Deque<Gun> guns = new ArrayDeque<>(gunRepository.getModels());


        Player p = players.poll();
        Gun gun = guns.poll();

        while (p != null && gun != null) {
            while (gun.canFire() && p.isAlive()) {
                int fire = gun.fire();
                p.takeLifePoints(fire);
            }
            if (gun.canFire()) {
                p = players.poll();
            } else if (p.isAlive()) {
                gun = guns.poll();
            }
        }

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                Deque<Gun> playerGuns = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());
                Gun playerGun = playerGuns.poll();
                while (playerGun != null) {
                    while (playerGun.canFire() && mainPlayer.isAlive()) {
                        int fire = playerGun.fire();
                        mainPlayer.takeLifePoints(fire);
                    }
                    if (!mainPlayer.isAlive()) {
                        return;
                    }
                    playerGun = playerGuns.poll();
                }
            }
        }
    }
}
