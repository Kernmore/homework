package students;

import java.util.*;

public class Group {
    private String groupName;
    private final int DEFAULT_SIZE = 10;
    private List<Student> students = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if(students.size() < DEFAULT_SIZE) {
            students.add(student);
        } else {
            throw new GroupOverflowException("No place in the group");
        }
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student st :
                students) {
            if(st.getLastName().equals(lastName)){
                return st;
            }
        }
        throw new StudentNotFoundException("No such student in the group");
    }

    public boolean removeStudentByID(int id) {
        for (Student st :
                students) {
            if (st.getId() == id){
                students.remove(st);
                return true;
            }
        }
        return false;
    }

    private void sort() {
        Collections.sort(students, new StudentComparator());
    }


    public void sortStudentsByName(){
        Collections.sort(students, new StudentNameComparator());
        System.out.println("The sort is performed by Name");
        for (Student st :
                students) {
            System.out.println(st);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sort();

        for (Student st :
                students) {
            sb.append(st.getLastName());
            sb.append(", ");
            sb.append(st.getName());
            sb.append("\n");

        }
        return "\nThe list of students of " + groupName + ": \n" + sb.toString();
    }
}
