package students;

public class Student extends Human  {
    private int id;
    private String groupName;

    public Student(String name, String lastName, Gender gender, int id, String groupName){
        super(name, lastName, gender);
        this.id = id;
        this.groupName = groupName;
    }
    public Student(String name, String lastName, Gender gender){
        super(name, lastName, gender);

    }
    public Student(){

    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return super.getLastName() + " " + super.getName() + "\nStudent's id = " + id + "\nGroup = " + groupName + "\n";
    }
}
