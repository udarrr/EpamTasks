package com.epam.automation.JavaErrorExceptions;

import com.epam.automation.JavaErrorExceptions.University.University;

import java.util.ArrayList;
import java.util.List;

public class UniversityManagement {

    UniversityManagement() {

        super();
    }

    public List<University> universities;

    public UniversityManagement(List<University> universities){

        this.universities = universities;
    }

    public List<University> getGroup()
    {
        List<University> groups = new ArrayList<>();

        for (University university : universities)
        {
            if(university.getFaculty().getGroup() != null)
            {
                groups.add(university);
            }
        }

        return groups;
    }
}
