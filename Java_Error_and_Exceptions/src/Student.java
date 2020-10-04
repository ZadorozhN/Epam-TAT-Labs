import java.util.HashMap;

public class Student {
    private int id;
    private String name;
    private Group group;
    private HashMap<String, Integer> grades;

    public Student(String name, Group group, int id) {
        this.name = name;
        this.group = group;
        this.id = id;
        grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public void setNotes(HashMap<String, Integer> notes) {
        this.grades = notes;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
