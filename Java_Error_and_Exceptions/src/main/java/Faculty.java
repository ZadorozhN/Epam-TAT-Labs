import lombok.*;

import static com.google.common.base.Preconditions.*;

@Data
@EqualsAndHashCode
@Builder
public class Faculty {
    public static final int MIN_LEGAL_ID = 0;
    @NonNull
    private String name;
    private int id;

    public Faculty(String name, int id){
        checkNotNull(name);
        checkArgument(id > MIN_LEGAL_ID);
        this.name = name;
        this.id = id;
    }
}
