package students;

public class CSVStringConverter implements StringConverter  {
    @Override
    public String toStringRepresentation(Student student) {
        StringBuilder str = new StringBuilder();
        str.append(student.getName() + ",");
        str.append(student.getLastName() + ",");
        str.append(student.getGender() + ",");
        str.append(student.getId() + ",");
        str.append(student.getGroupName() + ",");
        return str.toString();
    }

    /**
     * It is possible to create the Student object only with the String of the correct sequence:
     * Name, LastName, Gender, Id, GroupName.
     *
     */
    @Override
    public Student fromStringRepresentation(String str) {
        String[] array = str.split(",");

        Student st = new Student(array[0], array[1], Gender.valueOf(array[2]), Integer.parseInt(array[3]), array[4]);
        return st;
    }
}
