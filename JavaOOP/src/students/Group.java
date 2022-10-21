package students;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];
    private int amount;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                students[i].setGroupName(groupName);
                amount++;
                return;
            }
        }
        throw new GroupOverflowException("No place in the group");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName().equals(lastName)) {
                return students[i];
            }
        }
        throw new StudentNotFoundException("No such student in the group");
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                students[i] = null;
                amount--;
                return true;
            }
        }
        return false;
    }

    private Student[] sort() {

        Student temp;
        boolean sort = false;
        int count = 0;
        Student[] array = new Student[amount];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                array[count] = students[i];
                count++;
            }
        }

        while (!sort) {
            sort = true;

            for (int j = 0; j < array.length - 1; j++) {

                if (checkLastName(array[j], array[j + 1]) == array[j]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sort = false;
                }
            }

        }
        return array;
    }


    private Student checkLastName(Student st, Student stu) {
        String one = st.getLastName();
        String two = stu.getLastName();
        int length = Math.min(one.length(), two.length());
        for (int i = 0; i < length; i++) {
            if (one.charAt(i) == two.charAt(i)) {
                continue;
            } else if (one.charAt(i) > two.charAt(i)) {
                return st;
            } else {
                return stu;
            }
        }
        return st;
    }

    public void sortStudentsByName(){
        Arrays.sort(students, Comparator.nullsLast(new StudentNameComparator()));
        System.out.println("The sort is performed by Name");
        for (int i = 0; i < students.length; i++) {
            if(students[i] != null) {
                System.out.println(students[i].getName() + " " + students[i].getLastName());
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        Student[] array = sort();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                result += array[i].getLastName() + " ";
                result += array[i].getName() + "\n";
            }
        }
        return "\nThe list of students of " + groupName + ": \n" + result;
    }
}
