package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private GunRepository gunRepository;
    private PlayerRepository playerRepository;
    private Field field;


    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.playerRepository = new PlayerRepository();
        this.field = new FieldImpl();

    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if (type.equals("Pistol")) {
            this.gunRepository.add(new Pistol(name, bulletsCount));
        } else if (type.equals("Rifle")) {
            this.gunRepository.add(new Rifle(name, bulletsCount));
        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gunToAdd = this.gunRepository.findByName(gunName);
        if (gunToAdd == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        if (type.equals("Terrorist")) {
            playerRepository.add(new Terrorist(username, health, armor, gunToAdd));
        } else if (type.equals("CounterTerrorist")) {
            playerRepository.add(new CounterTerrorist(username, health, armor, gunToAdd));
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        List<Player> alivePlayers = playerRepository
                .getModels()
                .stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());
        return field.start(alivePlayers);
    }

    @Override
    public String report() {
        Collection<Player> models = this.playerRepository.getModels();
        models = models.stream().sorted((f, s) -> {
                    int result = f.getClass().getSimpleName().compareTo(s.getClass().getSimpleName());
                    if (result == 0) {
                        result = Integer.compare(s.getHealth(), f.getHealth());
                    }
                    if (result==0){
                        result = f.getUsername().compareTo(s.getUsername());
                    }
                    return result;
                })
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        models.forEach(p -> sb.append(p.toString()));
        return sb.toString().trim();
    }
}
