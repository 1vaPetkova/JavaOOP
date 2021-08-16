package T01WorkingWithAbstraction.lab.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> studentsByName;

    public StudentRepository() {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getStudentsByName() {
        return studentsByName;
    }

    public void add(Student student) {
        this.studentsByName.put(student.getName(),student);
    }

    public Student get(String name) {
        return this.studentsByName.get(name);
    }
}
