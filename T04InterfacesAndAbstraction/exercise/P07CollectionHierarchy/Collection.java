package T04InterfacesAndAbstraction.exercise.P07CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private int maxSize = 100;
    private final List<String> items;

    protected Collection() {
        this.items = new ArrayList<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<String> getItems() {
        return this.items;
    }
}
