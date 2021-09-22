package spaceStation.core;


import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronauts;
    private PlanetRepository planets;
    private Mission mission;
    int planetsExplored;

    public ControllerImpl() {
        this.astronauts = new AstronautRepository();
        this.planets = new PlanetRepository();
        this.mission = new MissionImpl();
        planetsExplored = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        if (type.equals("Biologist")) {
            astronauts.add(new Biologist(astronautName));
        } else if (type.equals("Geodesist")) {
            astronauts.add(new Geodesist(astronautName));
        } else if (type.equals("Meteorologist")) {
            astronauts.add(new Meteorologist(astronautName));
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        planets.add(new PlanetImpl(planetName));
        for (String item : items) {
            planets.findByName(planetName).getItems().add(item);
        }
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (astronauts.getModels().stream().noneMatch(a -> a.getName().equals(astronautName))) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronauts.remove(astronauts.findByName(astronautName));
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> explorers = astronauts.getModels().stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());
        int initialExplorers = explorers.size();
        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet exploredPlanet = planets.findByName(planetName);
        mission.explore(exploredPlanet, explorers);
        this.planetsExplored++;
        int astronautsDied = initialExplorers - explorers.size();
        return String.format(PLANET_EXPLORED, exploredPlanet.getName(), astronautsDied);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, planetsExplored))
                .append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());
        for (Astronaut a : astronauts.getModels()) {
            String bagItems = a.getBag().getItems().isEmpty() ? "none" :
                    String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, a.getBag().getItems());
            sb
                    .append(String.format(REPORT_ASTRONAUT_NAME, a.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(REPORT_ASTRONAUT_OXYGEN, a.getOxygen()))
                    .append(System.lineSeparator())
                    .append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, bagItems))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
