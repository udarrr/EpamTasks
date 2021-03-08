package com.epam.automation.javaio_stage2.MainTask.Readers;

import java.util.List;

public class DirectoriesReader {
    public double getDirectoriesNumber(List<String> strings) {
        return (double) strings.stream().filter(x -> x.contains("+--")).count();
    }
}
