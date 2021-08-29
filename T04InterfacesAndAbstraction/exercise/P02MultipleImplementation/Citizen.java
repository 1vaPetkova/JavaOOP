package T04InterfacesAndAbstraction.exercise.P02MultipleImplementation;

public class Citizen implements Person, Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthdayDate;

    public Citizen(String name, int age, String id, String birthdayDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdayDate = birthdayDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return birthdayDate;
    }

    @Override
    public String toString() {
        return "T04InterfacesAndAbstraction.exercise.P03BirthdayCelebrations.Citizen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", birthdayDate='" + birthdayDate + '\'' +
                '}';
    }
}
