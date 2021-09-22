package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private ArrayDeque<Gun> guns;
    private Map<String, Player> civilPlayers;
    private Neighbourhood neighbourhood;


    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.guns = new ArrayDeque<>();
        this.civilPlayers = new LinkedHashMap<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        civilPlayers.put(name, new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        if (type.equals("Pistol")) {
            Gun gun = new Pistol(name);
            guns.offer(gun);
            return String.format(GUN_ADDED, name, type);
        } else if (type.equals("Rifle")) {
            Gun gun = new Rifle(name);
            guns.offer(gun);
            return String.format(GUN_ADDED, name, type);
        } else {
            return GUN_TYPE_INVALID;
        }
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gunToAdd = guns.peek();
        if (gunToAdd == null) {
            return GUN_QUEUE_IS_EMPTY;
        } else if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(guns.poll());
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gunToAdd.getName(), mainPlayer.getName());
        } else if (!civilPlayers.containsKey(name)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        } else {
            civilPlayers.get(name).getGunRepository().add(guns.poll());
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gunToAdd.getName(), name);
        }
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, civilPlayers.values());
        if (mainPlayer.getLifePoints() == MainPlayer.INITIAL_LIFE_POINTS
                && civilPlayers.values().stream()
                .allMatch(c -> c.getLifePoints() == CivilPlayer.INITIAL_LIFE_POINTS)) {
            return FIGHT_NOT_HAPPENED;
        } else {

            long alivePlayers = civilPlayers.values().stream().filter(Player::isAlive).count();
            long deadPlayers = civilPlayers.size() - alivePlayers;
            StringBuilder sb = new StringBuilder(FIGHT_HAPPENED).append(System.lineSeparator());
            sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,
                            deadPlayers))
                    .append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, alivePlayers));

            civilPlayers.entrySet().removeIf(p -> !p.getValue().isAlive());
            return sb.toString().trim();
        }
    }
}
