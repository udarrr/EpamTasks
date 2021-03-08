package com.epam.automation.javaio_stage2.MainTask.Readers;

import com.epam.automation.javaio_stage2.MainTask.Exceptions.NoDirectoriesInPath;
import com.epam.automation.javaio_stage2.MainTask.Exceptions.NoFilesInDirectories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FilesReader {
    public List<String> readFile(File path) throws IOException {
        List<String> filesList = new LinkedList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                filesList.add(line);
            }

            return filesList;
        }
    }

    public double getAverageFilesQuantityInDirectories(List<String> strings) throws NoDirectoriesInPath {
        if (new DirectoriesReader().getDirectoriesNumber(strings) != 0) {
            return getFilesNumber(strings) /new DirectoriesReader().getDirectoriesNumber(strings);
        } else {
            throw new NoDirectoriesInPath("There are no directories in path");
        }
    }
    public double getFilesNumber(List<String> strings) {
        return (double) strings.stream().filter(x -> x.contains("\\--")).count();
    }

    public double getAverageLengthNameOfFiles(List<String> strings) throws NoFilesInDirectories {
        if (getFilesNumber(strings) != 0) {
            return getFileLengthsValue(strings) / getFilesNumber(strings);
        } else {
            throw new NoFilesInDirectories("There are no files in directories");
        }
    }

    private List<String> getFilesList(List<String> strings) {
        return strings.stream().filter(x -> x.contains("\\--")).collect(Collectors.toList());
    }

    private double getFileLengthsValue(List<String> strings) {
        double averageLength = 0;

        for (String line : getFilesList(strings)) {
            String[] splittedLine = line.split("\\\\--");

            if (splittedLine.length == 2) {
                String[] splittedFileNameAndExtention = splittedLine[1].split("\\.");
                averageLength += splittedFileNameAndExtention[0].length();
            }
        }

        return averageLength;
    }
}
