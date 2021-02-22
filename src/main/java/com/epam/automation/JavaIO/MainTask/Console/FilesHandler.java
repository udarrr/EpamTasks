package com.epam.automation.JavaIO.MainTask.Console;

import com.epam.automation.JavaIO.MainTask.Exception.NoDirectoriesInPath;
import com.epam.automation.JavaIO.MainTask.Exception.NoFilesInDirectories;
import com.epam.automation.JavaIO.MainTask.Reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesHandler {
    public void workWithFiles(File pathToFile) {
        Reader reader = new Reader();

        Printer printer = new Printer();

        List<String> list = new ArrayList<>();

        try {
            list = reader.readFile(pathToFile);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        printer.printAmountDirectories(reader.getDirectoriesNumber(list));
        printer.printAmountFiles(reader.getFilesNumber(list));

        try {
            printer.printAverageQuantityFilesInDirectories(reader.getAverageFilesQuantityInDirectories(list));
        } catch (NoDirectoriesInPath e) {
            System.err.println(e.getMessage());
        }

        try {
            printer.printAverageLengthNameOfFiles(reader.getAverageLengthNameOfFiles(list));
        } catch (NoFilesInDirectories e) {
            System.err.println(e.getMessage());
        }
    }
}
