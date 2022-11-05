package students;

import java.io.*;
import java.util.Scanner;

public class GroupFileStorage {
    private Student[] students;
    private CSVStringConverter csv = new CSVStringConverter();
    private File file;

    public void saveGroupToCSV(Group gr) throws IOException {
        students = new Student[gr.getStudents().size()];
        gr.getStudents().toArray(students);
        file = new File(gr.getGroupName() + ".csv");

        try (OutputStream os = new FileOutputStream(file); PrintWriter pw = new PrintWriter(os)) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null) {
                    pw.println(csv.toStringRepresentation(students[i]));
                }
            }

        }
    }

    /**
     * Read from the files all the CSV values and returns the Group of these values
     * also, removes the extension from the GroupName
     *
     * @param file
     * @return Group
     * @throws IOException
     * @throws GroupOverflowException
     */
    public Group loadGroupFromCSV(File file) throws IOException, GroupOverflowException {
        clearStudents(students);
        String[] strings = new String[students.length];
        Group group = new Group(file.getName());
        try (InputStream is = new FileInputStream(file); Scanner sc = new Scanner(is)) {
            for (int j = 0; j < strings.length; j++) {
                if (!sc.hasNextLine()) {
                    break;
                }
                strings[j] = sc.nextLine();
                students[j] = csv.fromStringRepresentation(strings[j]);
            }
        }

        for (int j = 0; j < students.length; j++) {
            if (students[j] != null) {
                group.addStudent(students[j]);
            }
        }
        String[] s = group.getGroupName().split("\\.");
        group.setGroupName(s[0]);
        return group;
    }

    public void clearStudents(Student[] st) {
        for (int i = 0; i < students.length; i++) {
            students[i] = null;
        }
    }

    public File findFileByGroupName(String groupName, File workFolder) {
        File file = new File(groupName + ".csv");
        File[] files = workFolder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (file.getName().equals(files[i].getName())) {
                System.out.println(true);
                return file;
            }
        }
        return null;
    }
}

