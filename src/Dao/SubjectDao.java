package Dao;

import Dto.SubjectDto;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {

    private static final List<SubjectDto> subjects = new ArrayList<>();

    public static boolean addSubject(SubjectDto subjectDto) {
        subjects.add(subjectDto);
        return true;
    }

    public static void viewAllSubjects() {
        if(subjects.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        System.out.println("ID | Name");
        for(SubjectDto s : subjects) {
            System.out.println(s.getId() + " | " + s.getName());
        }
    }

    public static void search(String id) {
        boolean found = false;
        for(SubjectDto s : subjects) {
            if(s.getId().equals(id)) {
                System.out.println(s.getId() + " | " + s.getName());
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Subject not found!");
        }
    }
}
