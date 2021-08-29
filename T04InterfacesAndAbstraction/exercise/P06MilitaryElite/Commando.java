package T04InterfacesAndAbstraction.exercise.P06MilitaryElite;

import java.util.List;

public interface Commando {
    void addMission(Mission mission);
    List<Mission> getMissions();
}
