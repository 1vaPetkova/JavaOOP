package T01WorkingWithAbstraction.lab.P03StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String comment;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.setComment();
    }

    private void setComment() {
        if (this.getGrade() >= 5.00) {
            this.comment = "Excellent student.";
        } else if (this.getGrade() >= 3.50) {
            this.comment = "Average student.";
        } else {
            this.comment = "Very nice person.";
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getInfo() {
        return String.format("%s is %d years old. %s", this.name, this.age, this.comment);
    }
}
