public class Group {
    private int id;
    private Faculty faculty;

    public Group(Faculty faculty, int id) {
        this.faculty = faculty;
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
