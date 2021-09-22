package T08ExceptionAndErrorHandling.P04ValidPerson;

public class Main {
    public static void main(String[] args) {

        try {
            Person p = createPerson("Franco", "Aimee", -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Person createPerson(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, age);
    }
}
