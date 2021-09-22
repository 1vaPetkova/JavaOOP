package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;

public class FieldImpl implements Field {
    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream()
                .filter(e -> e.getClass().getSimpleName().equals("Terrorist"))
                .collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream()
                .filter(e -> e.getClass().getSimpleName().equals("CounterTerrorist"))
                .collect(Collectors.toList());

        while (!areAllDead(terrorists) && !areAllDead(counterTerrorists)) {
            attack(terrorists, counterTerrorists);
            if (!areAllDead(counterTerrorists)) {
                attack(counterTerrorists, terrorists);
            }
        }

        if (areAllDead(counterTerrorists)) {
            return TERRORIST_WINS;
        } else {
            return COUNTER_TERRORIST_WINS;
        }
    }

    private boolean areAllDead(List<Player> players) {
        return players.stream().noneMatch(Player::isAlive);
    }

    private void attack(List<Player> attackers, List<Player> attacked) {
        for (Player attacker : attackers) {
            if (attacker.isAlive()) {
                for (Player a : attacked) {
                    if (a.isAlive()) {
                        a.takeDamage(attacker.getGun().fire());
                    }
                }
            }
        }
    }
}
