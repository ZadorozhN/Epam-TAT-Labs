import exceptions.*;

import java.util.*;
import java.util.stream.Collector;

public class App {
    public static void main(String[] args) {

        Faculty firstFaculty = new Faculty("First faculty", 1);
        Faculty secondFaculty = new Faculty("Second faculty", 1);

        Group firstGroup = new Group(firstFaculty, 1);
        Group secondGroup = new Group(firstFaculty, 2);
        Group thirdGroup = new Group(secondFaculty, 3);
        Group fourthGroup = new Group(secondFaculty, 4);

        Student firstStudent = new Student("Nick", firstGroup, 1);
        Student secondStudent = new Student("Nick", firstGroup, 2);
        Student thirdStudent = new Student("Nick", secondGroup, 3);
        Student fourthStudent = new Student("Nick", secondGroup, 4);
        Student fifthStudent = new Student("Nick", thirdGroup, 5);
        Student sixthStudent = new Student("Nick", thirdGroup, 6);
        Student seventhStudent = new Student("Nick", fourthGroup, 7);
        Student eighthStudent = new Student("Nick", fourthGroup, 8);

        Faculty[] faculties = new Faculty[]{firstFaculty, secondFaculty};

        Group[] groups = new Group[]{firstGroup, secondGroup, thirdGroup, fourthGroup};

        Student[] students = new Student[]{firstStudent, secondStudent, thirdStudent, fourthStudent,
                fifthStudent, sixthStudent, seventhStudent, eighthStudent};

        Random random = new Random();

        for (int i = 0; i < students.length; i++) {
            students[i].putNote("Math", (Math.abs(random.nextInt())) % 10 + 1);
        }

        //First task
        double averageGrade = 0;
        int countOfGrades = 0;
        int studentId = 1;

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }
        });

        Student student = students[Arrays.binarySearch(Arrays.stream(students).mapToInt(x -> x.getId()).toArray(), studentId)];

        for (HashMap.Entry<String, Integer> entry : student.getGrades().entrySet()) {
            averageGrade += entry.getValue();
            countOfGrades++;
        }

        averageGrade = averageGrade / countOfGrades;

        System.out.println("The average grade of student with id " + student.getId() + " is " + averageGrade);

        if(faculties.length == 0)
            try {
                throw new NoFacultiesException("University has no faculties");
            } catch (NoFacultiesException e) {
                System.out.println(e.getMessage());
                return;
            }

        for(int i = 0; i < students.length; i++){
            if(students[i].getGrades().entrySet().size() == 0)
                try {
                    throw new NoDisciplinesException("Student has no disciplines");
                } catch (NoDisciplinesException e) {
                    System.out.println(e.getMessage());
                    return;
                }
        }

        //Second task
        averageGrade = 0;
        countOfGrades = 0;
        Group group = firstGroup;
        Faculty faculty = firstFaculty;
        try {
            for (int i = 0; i < groups.length; i++) {
                if (groups[i].getFaculty() == faculty)
                    break;
                if (i == groups.length - 1)
                    throw new NoGroupsException("Faculty has no students");
            }
            for (int i = 0; i < students.length; i++) {
                if (students[i].getGroup() == group)
                    break;
                if (i == students.length - 1)
                    throw new NoStudentsException("Group has no students");
            }
            for (int i = 0; i < students.length; i++) {
                if (students[i].getGroup().getId() == group.getId() && group.getFaculty() == faculty) {
                    if (students[i].getGrades().get("Math") < 0 || students[i].getGrades().get("Math") > 10)
                        throw new IncorrectGradeException("Incorrect grade ", students[i].getGrades().get("Math"));
                    averageGrade += students[i].getGrades().get("Math");
                    countOfGrades++;
                }
            }
        } catch (IncorrectGradeException e) {
            System.out.println(e.getMessage());
        }
        catch (NoStudentsException e){
            System.out.println(e.getMessage());
        } catch (NoGroupsException e) {
            System.out.println(e.getMessage());
        }

        averageGrade = averageGrade / countOfGrades;

        System.out.println("The average grade of students which study in group with id " + group.getId() + " is " + averageGrade);

        //Third task
        averageGrade = 0;
        countOfGrades = 0;

        try {
            for (int i = 0; i < students.length; i++) {
                if (students[i].getGrades().get("Math") != null) {
                    if (students[i].getGrades().get("Math") < 0 || students[i].getGrades().get("Math") > 10)
                        throw new IncorrectGradeException("Incorrect grade ", students[i].getGrades().get("Math"));
                    averageGrade += students[i].getGrades().get("Math");
                    countOfGrades++;
                }
            }
            averageGrade = averageGrade / countOfGrades;
        } catch (IncorrectGradeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The average grade in math at university is " + averageGrade);
    }
}