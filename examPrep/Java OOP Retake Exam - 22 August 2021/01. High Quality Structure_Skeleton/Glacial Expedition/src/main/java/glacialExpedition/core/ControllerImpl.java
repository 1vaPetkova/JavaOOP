package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorersRepo;
    private StateRepository states;
    private Mission mission;
    private int exploredStates;

    public ControllerImpl() {
        this.explorersRepo = new ExplorerRepository();
        this.states = new StateRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;
        if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorersRepo.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State stateToAdd = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            stateToAdd.getExhibits().add(exhibit);
        }
        states.add(stateToAdd);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorersRepo.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        this.explorersRepo.remove(explorer);
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorers = explorersRepo
                .getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        State exploredState = states.byName(stateName);
        int initialExplorers = explorers.size();
        mission.explore(exploredState, explorers);
        int retiredExplorers = initialExplorers - explorers.size();
        this.exploredStates++;
        return String.format(STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format(FINAL_STATE_EXPLORED, exploredStates))
                .append(System.lineSeparator())
                .append(FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());
        for (Explorer explorer : explorersRepo.getCollection()) {
            String exhibits = explorer.getSuitcase().getExhibits().isEmpty() ? "None" :
                    String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits());
            sb
                    .append(String.format(FINAL_EXPLORER_NAME, explorer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, exhibits))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
