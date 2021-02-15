package com.epam.automation.JavaErrorExceptions.Management;

import com.epam.automation.JavaErrorExceptions.Exception.NumberIsNotInRangeException;
import com.epam.automation.JavaErrorExceptions.University.Faculty;
import com.epam.automation.JavaErrorExceptions.University.Group;
import com.epam.automation.JavaErrorExceptions.University.Student;
import com.epam.automation.JavaErrorExceptions.University.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Management {

    private final List<Faculty> faculties;

    public Management(List<Faculty> faculties) {

        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {

        return faculties;
    }

    public void addFaculty(String nameFaculty) {

        int nextIdFaculty = faculties.size() + 1;


        if (faculties.stream().noneMatch(x -> {
            return x.getNameFaculty().equals(nameFaculty);
        })) {

            faculties.add(new Faculty(nextIdFaculty, nameFaculty, new ArrayList<>()));
        }
    }

    public int getIndexFaculty(String faculty) {

        int indexFaculty = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.size(); i++) {

            if (faculties.get(i).getNameFaculty().equals(faculty)) {

                indexFaculty = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexFaculty : -1;
    }

    public int getIndexFaculty(int idFaculty) {

        int indexFaculty = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.size(); i++) {

            if (faculties.get(i).getIdFaculty() == idFaculty) {

                indexFaculty = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexFaculty : -1;
    }

    public double getAvgMarkFromParticularStudentAllSubjects(String nameStudent) {

        double avgMark;

        try {
            avgMark = faculties.stream().
                    flatMap(x -> x.getGroup().stream()).
                    flatMap(z -> z.getStudent().stream()).
                    filter(v -> v.getName().equals(nameStudent)).
                    flatMap(n -> n.getSubject().stream()).
                    flatMap(m -> m.getMark().stream()).mapToInt(s -> s).average().orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e){
            return -1;
        }

        return avgMark;
    }


    public double getAvgMarkFromParticularGroupStudentSubject(String nameFaculty, String nameGroup, String nameSubject) {

        double avgMark;

        int indexFaculty = getIndexFaculty(nameFaculty);
        int indexGroup = getIndexGroup(indexFaculty, nameGroup);

        if (indexFaculty > -1 && indexGroup > -1) {
            try {
                avgMark = faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().stream().
                        flatMap(x -> x.getSubject().stream()).
                        filter(z -> z.getTypeSubject().equals(nameSubject)).
                        flatMap(c -> c.getMark().stream()).mapToInt(v -> v).average().orElseThrow(NoSuchElementException::new);
            } catch (NoSuchElementException e) {
                return -1;
            }
        }
        else {
            return -1;
        }

        return avgMark;
    }

    public double getAvgMarkWholeUniversityFromParticularSubject(String nameSubject) {

        double avgMark;

        try {
            avgMark = faculties.stream().
                    flatMap(z -> z.getGroup().stream()).
                    flatMap(x -> x.getStudent().stream()).
                    flatMap(c -> c.getSubject().stream()).filter(v -> v.getTypeSubject().equals(nameSubject)).
                    flatMap(b -> b.getMark().stream()).mapToInt(n -> n).average().orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e){
            return -1;
        }

        return avgMark;
    }

    public void addGroup(String nameFaculty, String nameGroup) {

        int nextIdGroup = getGroup().size() + 1;

        int indexFaculty = 0;
        boolean isFaculty = false;

        for (int i = 0; i < faculties.size(); i++) {

            if (faculties.get(i).getNameFaculty().equals(nameFaculty)) {

                indexFaculty = i;
                isFaculty = true;

                break;
            }
        }

        if (isFaculty &&
                faculties.get(indexFaculty).getGroup().stream().noneMatch(z -> {

                    return z.getNameGroup().equals(nameGroup);
                })) {

            faculties.get(indexFaculty).getGroup().add(new Group(nextIdGroup, nameGroup, new ArrayList<>()));
        }
    }

    public void addGroup(int idFaculty, String nameGroup) {

        int nextIdGroup = getGroup().size() + 1;

        int indexFaculty = 0;
        boolean isFaculty = false;

        for (int i = 0; i < faculties.size(); i++) {

            if (faculties.get(i).getIdFaculty() == idFaculty) {

                indexFaculty = i;
                isFaculty = true;

                break;
            }
        }

        if (isFaculty &&
                faculties.get(indexFaculty).getGroup().stream().noneMatch(z -> {

                    return z.getNameGroup().equals(nameGroup);
                })) {

            faculties.get(indexFaculty).getGroup().add(new Group(nextIdGroup, nameGroup, new ArrayList<>()));
        }
    }

    public List<Group> getGroup() {

        return faculties.stream().flatMap(x -> x.getGroup().stream()).collect(Collectors.toList());
    }

    public int getIndexGroup(int indexFaculty, String group) {

        int indexGroup = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.get(indexFaculty).getGroup().size(); i++) {

            if (faculties.get(indexFaculty).getGroup().get(i).getNameGroup().equals(group)) {

                indexGroup = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexGroup : -1;
    }

    public int getIndexGroup(int indexFaculty, int idGroup) {

        int indexGroup = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.get(indexFaculty).getGroup().size(); i++) {

            if (faculties.get(indexFaculty).getGroup().get(i).getIdGroup() == idGroup) {

                indexGroup = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexGroup : -1;
    }

    public List<Group> getGroup(int idFaculty) {

        return faculties.stream().
                filter(x->x.getIdFaculty() == idFaculty).
                flatMap(z->z.getGroup().stream()).
                collect(Collectors.toList());
    }

    public void addStudent(String nameGroup, String nameStudent) {

        int nextIdStudent = getStudent().size() + 1;

        int indexGroup = 0;
        int indexFaculty = 0;
        boolean isGroup = false;

        for (int i = 0; i < faculties.size(); i++) {

            if (!isGroup) {

                for (int j = 0; j < faculties.get(i).getGroup().size(); j++) {

                    if (faculties.get(i).getGroup().get(j).getNameGroup().equals(nameGroup)) {

                        indexFaculty = i;
                        indexGroup = j;
                        isGroup = true;

                        break;
                    }
                }
            } else {

                break;
            }
        }

        if (isGroup &&
                faculties.
                        get(indexFaculty).getGroup().
                        get(indexGroup).getStudent().
                        stream().noneMatch(z -> {

                    return z.getName().equals(nameStudent);
                })) {

            faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().add(new Student(nextIdStudent, nameStudent, new ArrayList<>()));
        }
    }

    public void addStudent(int idGroup, String nameStudent) {

        int nextIdStudent = getStudent().size() + 1;

        int indexGroup = 0;
        int indexFaculty = 0;
        boolean isGroup = false;

        for (int i = 0; i < faculties.size(); i++) {

            if (!isGroup) {

                for (int j = 0; j < faculties.get(i).getGroup().size(); j++) {

                    if (faculties.get(i).getGroup().get(j).getIdGroup() == idGroup) {

                        indexFaculty = i;
                        indexGroup = j;
                        isGroup = true;

                        break;
                    }
                }
            } else {

                break;
            }
        }

        if (isGroup &&
                faculties.
                        get(indexFaculty).getGroup().
                        get(indexGroup).getStudent().
                        stream().noneMatch(z -> {

                    return z.getName().equals(nameStudent);
                })) {

            faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().add(new Student(nextIdStudent, nameStudent, new ArrayList<>()));
        }
    }

    public List<Student> getStudent() {

        return faculties.stream().flatMap(z -> z.getGroup().stream()).flatMap(x -> x.getStudent().stream()).collect(Collectors.toList());
    }

    public int getIndexStudent(int indexFaculty, int indexGroup, int idStudent) {

        int indexStudent = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().size(); i++) {

            if (faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().get(i).getIdStudent() == idStudent) {

                indexStudent = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexStudent : -1;
    }

    public List<Student> getStudent(int idGroup) {

        return faculties.stream().
                flatMap(z -> z.getGroup().stream()).
                filter(m->m.getIdGroup() == idGroup).
                flatMap(x -> x.getStudent().stream()).
                collect(Collectors.toList());
    }

    public void addSubject(int idStudent, String nameSubject) {

        int indexFaculty = 0;
        int indexGroup = 0;
        int indexStudent = 0;

        int nextIdSubject = getSubjectOfStudent(idStudent).size() + 1;

        boolean isStudent = false;


        for (int i = 0; i < faculties.size(); i++) {

            if (!isStudent) {

                for (int j = 0; j < faculties.get(i).getGroup().size(); j++) {

                    if (!isStudent) {

                        for (int k = 0; k < faculties.get(i).getGroup().get(j).getStudent().size(); k++) {

                            if (faculties.get(i).getGroup().get(j).getStudent().get(k).getIdStudent() == idStudent) {

                                indexFaculty = i;
                                indexGroup = j;
                                indexStudent = k;
                                isStudent = true;

                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }

            } else {
                break;
            }
        }

        if (isStudent &&
                faculties.
                        get(indexFaculty).getGroup().
                        get(indexGroup).getStudent().
                        get(indexStudent).getSubject().
                        stream().noneMatch(z -> {

                    return z.getTypeSubject().equals(nameSubject);
                })) {

            faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().get(indexStudent).getSubject().add(new Subject(nextIdSubject, nameSubject, new ArrayList<>()));
        }
    }

    public List<Subject> getSubjectOfStudent(int idStudent) {

        return faculties.stream().
                flatMap(z -> z.getGroup().stream()).
                flatMap(x -> x.getStudent().stream()).
                filter(c -> c.getIdStudent() == idStudent).
                flatMap(v -> v.getSubject().stream()).
                collect(Collectors.toList());
    }

    public int getIndexSubject(int indexFaculty, int indexGroup, int indexStudent, int idSubject) {

        int indexSubject = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().get(indexStudent).getSubject().size(); i++) {

            if (faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().get(indexStudent).getSubject().get(i).getIdSubject() == idSubject) {

                indexSubject = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexSubject : -1;
    }

    public List<Subject> getSubject(int idStudent) {

        return faculties.stream().
                flatMap(z -> z.getGroup().stream()).
                flatMap(x -> x.getStudent().stream()).
                filter(v -> v.getIdStudent() == idStudent).
                flatMap(c -> c.getSubject().stream()).
                collect(Collectors.toList());
    }

    public List<Subject> getSubject(int idStudent, int idSubject) {

        return faculties.stream().
                flatMap(z -> z.getGroup().stream()).
                flatMap(x -> x.getStudent().stream()).
                filter(v -> v.getIdStudent() == idStudent).
                flatMap(c -> c.getSubject().stream()).
                filter(b -> b.getIdSubject() == idSubject).
                collect(Collectors.toList());
    }

    public void addMarks(int indexFaculty, int indexGroup, int indexStudent, int indexSubject, int mark) {

        try {
            if ((mark >= 0) && (mark <= 10)){

                faculties.get(indexFaculty).
                                getGroup().get(indexGroup).
                                getStudent().get(indexStudent).
                                getSubject().get(indexSubject).setMark(mark);
            }
            else {
                throw new NumberIsNotInRangeException();
            }

        } catch (NumberIsNotInRangeException e) {
            System.out.println("You entered wrong number, mark can't be less 0 and more than 10");
        }
    }

    public void addMarks(int inputIdFaculty,int inputIdGroup,int inputIdStudent,int inputIdSubject,List<Integer> marks){

        int indexFaculty = getIndexFaculty(inputIdFaculty);
        int indexGroup = getIndexGroup(indexFaculty, inputIdGroup);
        int indexStudent = getIndexStudent(indexFaculty, indexGroup, inputIdStudent);
        int indexSubject = getIndexSubject(indexFaculty, indexGroup,indexStudent,inputIdSubject);

        faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().get(indexStudent).getSubject().get(indexSubject).setMarks(marks);
    }
}