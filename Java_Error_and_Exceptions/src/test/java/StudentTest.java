import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    public static final Group LEGAL_GROUP = Mockito.mock(Group.class);
    public static final int LEGAL_ID = 3;
    public static final String LEGAL_NAME = "Nikita";

    @Test
    void createStudent(){
        assertDoesNotThrow(() -> new Student(LEGAL_NAME, LEGAL_GROUP, LEGAL_ID));
    }

    @Test
    void getIdTest() {
        Student student = Student.builder().group(LEGAL_GROUP).id(LEGAL_ID).name(LEGAL_NAME).build();
        assertEquals(student.getId(), LEGAL_ID);
    }

    @Test
    void getNameTest() {
        Student student = Student.builder().group(LEGAL_GROUP).id(LEGAL_ID).name(LEGAL_NAME).build();
        assertEquals(student.getName(), LEGAL_NAME);
    }

    @Test
    void getGroupTest() {
        Student student = Student.builder().group(LEGAL_GROUP).id(LEGAL_ID).name(LEGAL_NAME).build();
        assertEquals(student.getGroup(), LEGAL_GROUP);
    }

    @Test
    void setGroupTest(){
        Student student = Student.builder().group(LEGAL_GROUP).id(LEGAL_ID).name(LEGAL_NAME).build();
        int newGroupId = 10;
        Group newGroup = Mockito.mock(Group.class);
        Mockito.when(newGroup.getId()).thenReturn(newGroupId);
        student.setGroup(newGroup);
        assertEquals(student.getGroup().getId(), newGroup.getId());

    }

    @Test
    void putGradeTest() {
        String discipline = "Math";
        int note = 10;
        Student student = Student.builder().group(LEGAL_GROUP).id(LEGAL_ID).name(LEGAL_NAME).build();
        student.putNote(discipline, note);
        assertEquals(student.getGrades().get(discipline), note);
    }

}