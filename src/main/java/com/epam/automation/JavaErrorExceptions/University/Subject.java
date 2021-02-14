package com.epam.automation.JavaErrorExceptions.University;

import java.util.List;

public class Subject {

    String typeSubject;
    List<Integer> mark;

    public Subject(List<Integer> mark) {
        this.mark = mark;
    }

    public Subject(String typeSubject, List<Integer> mark) {
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

    public void setMark(List<Integer> mark) {
        this.mark = mark;
    }
}
