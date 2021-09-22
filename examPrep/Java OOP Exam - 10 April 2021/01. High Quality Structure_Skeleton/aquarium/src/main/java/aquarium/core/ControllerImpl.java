package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.LinkedHashMap;

import java.util.Map;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariums.putIfAbsent(aquariumName, aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);


    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        aquariums.get(aquariumName).addDecoration(decoration);
        this.decorations.remove(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = aquariums.get(aquariumName);

        Fish fishToAdd = null;
        if (fishType.equals("FreshwaterFish")) {
            fishToAdd = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            fishToAdd = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        if ((fishType.equals("FreshwaterFish") && !aquarium.getClass().getSimpleName().equals("FreshwaterAquarium"))
                || (fishType.equals("SaltwaterFish") && !aquarium.getClass().getSimpleName().equals("SaltwaterAquarium"))) {
            return WATER_NOT_SUITABLE;
        }
        aquarium.addFish(fishToAdd);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums.get(aquariumName);
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.get(aquariumName);
        double sumDecorations = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double sumFish = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        return String.format(VALUE_AQUARIUM, aquariumName, sumDecorations + sumFish);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums.values()) {
            sb
                    .append(aquarium.getInfo())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
