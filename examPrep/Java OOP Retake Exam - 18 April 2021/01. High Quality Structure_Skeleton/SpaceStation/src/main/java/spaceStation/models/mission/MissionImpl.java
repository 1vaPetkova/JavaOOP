package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;


import java.util.*;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Deque<String> items = new ArrayDeque<>(planet.getItems());
        List<Astronaut> explorers = new ArrayList<>(astronauts);

        for (Astronaut astronaut : explorers) {
            while (astronaut.canBreath() && !items.isEmpty()) {
                String item = items.poll();
                astronaut.getBag().getItems().add(item);
                astronaut.breath();
            }
            if (!astronaut.canBreath()) {
                astronauts.remove(astronaut);
            }
            if (items.isEmpty()) {
                break;
            }
        }
    }
}
