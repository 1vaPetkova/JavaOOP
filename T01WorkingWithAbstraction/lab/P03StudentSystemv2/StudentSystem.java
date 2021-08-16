package T01WorkingWithAbstraction.lab.P03StudentSystemv2;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public String parseCommand(String[] tokens) {
        String name = tokens[1];
        if ("Create".equals(tokens[0]) && !studentsByName.containsKey(name)) {
            int age = Integer.parseInt(tokens[2]);
            double grade = Double.parseDouble(tokens[3]);
            Student student = new Student(name, age, grade);
            this.studentsByName.put(name, student);
        } else if ("Show".equals(tokens[0]) && studentsByName.containsKey(name)) {
            return this.studentsByName.get(name).getInfo();
        }
        return null;
    }
}

