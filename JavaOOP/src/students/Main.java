package students;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        Student student1 = new Student("Abigail", "Bbarbux", Gender.FEMALE);
        Student student2 = new Student("Ker", "Babuil", Gender.FEMALE);
        Student student3 = new Student("Ivan", "Lovecraft", Gender.MALE);
        Student student4 = new Student("Ron", "Brabus", Gender.TRANSFORMER);
        Student student5 = new Student("Kent", "Rom", Gender.TRANSFORMER);
        Student student6 = new Student("Andr", "Keri", Gender.TRANSFORMER);
        Student student7 = new Student("Robb", "Baves", Gender.TRANSFORMER);

        Group group = new Group("Team A");

        student1.setId(4);
        student2.setId(2);
        student3.setId(3);

        try {
            group.addStudent(student1);
            group.addStudent(student2);
            group.addStudent(student3);
            group.addStudent(student4);
            group.addStudent(student5);
            group.addStudent(student6);
            System.out.println(group.searchStudentByLastName("Lovecraft"));
            System.out.println(group.removeStudentByID(4));
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        } catch (StudentNotFoundException e){
            e.printStackTrace();
        }
//        System.out.println(group.toString());
//
//        group.sortStudentsByName();
//
//        StudentScanner st = new StudentScanner();
//        System.out.println(st.toString());
//        try {
//            group.addStudent(st.getSt());
//        } catch (GroupOverflowException e) {
//            e.printStackTrace();
//        }
//        CSVStringConverter csv = new CSVStringConverter();
//        String s = csv.toStringRepresentation(student1);
//        System.out.println(csv.fromStringRepresentation(s));


        GroupFileStorage gfs = new GroupFileStorage();
        Group grp;
        File file = new File(group.getGroupName() + ".csv");
        try {
            gfs.saveGroupToCSV(group);
            grp = gfs.loadGroupFromCSV(file);
        } catch (GroupOverflowException | IOException e) {
            throw new RuntimeException(e);
        }

        File directory = new File(System.getProperty("user.dir"));

        System.out.println(grp.toString());
        gfs.findFileByGroupName(group.getGroupName(), directory);

    }
}
