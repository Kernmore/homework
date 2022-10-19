package students;

import java.util.Scanner;

public class StudentScanner extends Student {
    private Scanner sc;
    private String name;
    private String lastName;
    private String groupName;
    Gender gender;
    private int id;
    private Student st;

    public StudentScanner() {
        System.out.println("Student Builder, please fill in all the required details");
        sc = new Scanner(System.in);
        System.out.println("Set the name");
        name = sc.nextLine();
        System.out.println("Set the lastname");
        lastName = sc.nextLine();
        System.out.println("Set the groupname");
        groupName = sc.nextLine();
        System.out.println("Set the gender");
        gender = Gender.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Set the age");
        id = sc.nextInt();
        st = new Student(name, lastName, gender, id, groupName);
    }

    public Student getSt() {
        return st;
    }

    @Override
    public String toString() {
        return "Student: " + st;
    }
}
