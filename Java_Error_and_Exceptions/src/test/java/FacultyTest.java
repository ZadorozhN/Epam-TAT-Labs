import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {
    public static final String LEGAL_NAME = "IT";
    public static final int LEGAL_ID = 3;

    @Test
    void createFacultyTest() {
        assertDoesNotThrow(() -> new Faculty(LEGAL_NAME, LEGAL_ID));
    }

    @Test
    void getFacultyNameTest() {
        Faculty faculty = new Faculty(LEGAL_NAME, LEGAL_ID);
        assertEquals(faculty.getName(), LEGAL_NAME);
    }

    @Test
    void getFacultyIdTest() {
        Faculty faculty = new Faculty(LEGAL_NAME, LEGAL_ID);
        assertEquals(faculty.getId(), LEGAL_ID);
    }

    @Test
    void setFacultyNameTest() {
        Faculty faculty = new Faculty(LEGAL_NAME, LEGAL_ID);
        String newLegalName = "NewIT";
        faculty.setName(newLegalName);
        assertEquals(faculty.getName(), newLegalName);
    }

    @Test
    void setFacultyIdTest() {
        Faculty faculty = new Faculty(LEGAL_NAME, LEGAL_ID);
        int newLegalId = 2;
        faculty.setId(newLegalId);
        assertEquals(faculty.getId(), newLegalId);
    }
}