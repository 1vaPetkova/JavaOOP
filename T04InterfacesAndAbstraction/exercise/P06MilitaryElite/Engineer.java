package T04InterfacesAndAbstraction.exercise.P06MilitaryElite;

import java.util.List;

public interface Engineer {
    void addRepair(Repair repair);

    List<Repair> getRepairs();
}
