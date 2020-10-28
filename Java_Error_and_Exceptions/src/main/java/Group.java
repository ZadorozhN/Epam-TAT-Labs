import lombok.*;

import static com.google.common.base.Preconditions.*;

@Data
@EqualsAndHashCode
@Builder
public class Group {
    public static final int MIN_LEGAL_ID = 0;
    @NonNull
    private Faculty faculty;
    private int id;

    public Group(Faculty faculty, int id){
        checkNotNull(faculty);
        checkArgument(id > MIN_LEGAL_ID);
        this.faculty = faculty;
        this.id = id;
    }
}
