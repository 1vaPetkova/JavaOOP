package T03Inheritance.lab.P05StackOfStrings;

import java.util.ArrayList;


public class StackOfStrings {
    private final ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }


    public String pop() {
        String lastElement = this.data.get(data.size() - 1);
        data.remove(lastElement);
        return lastElement;
    }


    public String peek() {
        return this.data.get(data.size() - 1);
    }


    public boolean isEmpty() {
        return this.data.size() == 0;
    }
}
