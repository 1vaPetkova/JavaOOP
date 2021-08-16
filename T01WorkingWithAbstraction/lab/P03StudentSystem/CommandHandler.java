package T01WorkingWithAbstraction.lab.P03StudentSystem;

public class CommandHandler {
    private StudentRepository repository;

    public CommandHandler() {
        this.repository = new StudentRepository();
    }

    public String handleCommand(String[] tokens) {
        if (tokens[0].equals("Create")) {
            String name = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double grade = Double.parseDouble(tokens[3]);
            Student student = new Student(name, age, grade);
            this.repository.add(student);
        } else if (tokens[0].equals("Show")) {
            String name = tokens[1];
            if (this.repository.getStudentsByName().containsKey(name)){
            return this.repository.get(name).getInfo();
            }
        }
        return null;
    }

}
