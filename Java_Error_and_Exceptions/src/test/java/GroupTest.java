import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    public static final Faculty LEGAL_FACULTY = Mockito.mock(Faculty.class);
    public static final int LEGAL_GROUP_ID = 3;

    @Test
    void createGroupTest() {
        assertDoesNotThrow(() -> new Group(LEGAL_FACULTY, LEGAL_GROUP_ID));
    }

    @Test
    void getFacultyTest() {
        Group group = new Group(LEGAL_FACULTY, LEGAL_GROUP_ID);
        assertEquals(group.getFaculty(), LEGAL_FACULTY);
    }

    @Test
    void setFacultyTest() {
        Group group = new Group(LEGAL_FACULTY, LEGAL_GROUP_ID);
        int secondFacultyId = 5;
        String secondFacultyName = "NewIT";
        Faculty secondLegalFaculty = new Faculty(secondFacultyName, secondFacultyId);
        group.setFaculty(secondLegalFaculty);
        assertEquals(group.getFaculty(), secondLegalFaculty);
    }

    @Test
    void getIdTest() {
        Group group = new Group(LEGAL_FACULTY, LEGAL_GROUP_ID);
        assertEquals(group.getId(), LEGAL_GROUP_ID);
    }

    @Test
    void setIdTest() {
        Group group = new Group(LEGAL_FACULTY, LEGAL_GROUP_ID);
        int newLegalGroupId = 5;
        group.setId(newLegalGroupId);
        assertEquals(group.getId(), newLegalGroupId);
    }
}