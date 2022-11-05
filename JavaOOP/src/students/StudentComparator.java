package students;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int r = o1.getLastName().compareTo(o2.getLastName());
        return r;
    }
}

