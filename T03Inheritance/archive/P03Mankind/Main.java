package T03Inheritance.archive.P03Mankind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] studentInfo = scan.nextLine().split("\\s+");
        String studentFirstName = studentInfo[0];
        String studentLastName = studentInfo[1];
        String facultyNumber = null;
        if (studentInfo.length > 2) {
            facultyNumber = studentInfo[2];
        }
        String[] workerInfo = scan.nextLine().split("\\s+");
        String workerFirstName = workerInfo[0];
        String workerLastName = workerInfo[1];
        double weekSalary = 0.0;
        double workHoursPerDay = 0.0;
        if (workerInfo.length > 2) {
            weekSalary = Double.parseDouble(workerInfo[2]);
        }
        if (workerInfo.length > 3) {
            workHoursPerDay = Double.parseDouble(workerInfo[3]);
        }
        try {
            Human student = new Student(studentFirstName, studentLastName, facultyNumber);
            Human worker = new Worker(workerFirstName, workerLastName,
                    weekSalary,workHoursPerDay);
            System.out.println(student);
            System.out.println(worker);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
