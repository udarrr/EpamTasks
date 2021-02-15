package com.epam.automation.JavaErrorExceptions.University;

import java.util.List;

public class Subject {

    int idSubject;
    String typeSubject;
    List<Integer> mark;

    public Subject(List<Integer> mark) {
        this.mark = mark;
    }

    public Subject(int idSubject, String typeSubject, List<Integer> mark) {
        this.idSubject = idSubject;
        this.typeSubject = typeSubject;
        this.mark = mark;
    }

    public List<Integer> getMark() {
        return mark;
    }

    public String getTypeSubject() {
        return typeSubject;
    }

    public void setTypeSubject(String typeSubject) {
        this.typeSubject = typeSubject;
    }

    public void setMark(int mark) {
        this.mark.add(mark);
    }

    public void setMarks(List<Integer> marks) {
        this.mark = marks;
    }

    public int getIdSubject() {

        return idSubject;
    }
}
