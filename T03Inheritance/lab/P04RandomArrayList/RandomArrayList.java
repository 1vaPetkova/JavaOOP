package T03Inheritance.lab.P04RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    public Object getRandomElement() {
        int index = new Random().nextInt(super.size());
        return super.get(index);

    }
}
