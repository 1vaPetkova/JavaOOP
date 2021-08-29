package T04InterfacesAndAbstraction.exercise.P07CollectionHierarchy;

import java.util.List;

public class AddCollection extends Collection implements Addable{

    protected AddCollection() {
        super();
    }

    @Override
    public int add(String item) {
        super.getItems().add(item);
        return getItems().indexOf(item);
    }
}
