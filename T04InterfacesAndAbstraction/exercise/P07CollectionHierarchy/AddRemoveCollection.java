package T04InterfacesAndAbstraction.exercise.P07CollectionHierarchy;

import java.util.List;

public class AddRemoveCollection extends Collection implements AddRemovable {


    protected AddRemoveCollection() {
        super();
    }

    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size() - 1);
    }

    @Override
    public int add(String item) {
        getItems().add(0, item);
        return 0;
    }
}
