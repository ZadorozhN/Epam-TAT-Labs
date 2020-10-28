import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;

import static com.google.common.base.Preconditions.*;

@Getter
public class Student {
    public static int MIN_GRADE = 1;
    public static int MAX_GRADE = 10;

    private int id;
    @NonNull
    private String name;
    @Setter
    @NonNull
    private Group group;
    private HashMap<String, Integer> grades;

    @Builder
    public Student(String name, Group group, int id) {
        checkNotNull(name);
        checkNotNull(group);
        checkArgument(id > 0);

        this.name = name;
        this.group = group;
        this.id = id;
        grades = new HashMap<>();
    }

    public HashMap<String, Integer> getGrades(){
        return new HashMap<>(grades);
    }

    public void putNote(String discipline, int note) {
        checkNotNull(discipline);
        checkArgument(note >= MIN_GRADE && note <= MAX_GRADE);
        grades.put(discipline, note);
    }
}
