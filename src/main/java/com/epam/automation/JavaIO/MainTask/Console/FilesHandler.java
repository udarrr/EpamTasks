package com.epam.automation.JavaIO.MainTask.Console;

import com.epam.automation.JavaIO.MainTask.Exception.NoDirectoriesInPath;
import com.epam.automation.JavaIO.MainTask.Exception.NoFilesInDirectories;
import com.epam.automation.JavaIO.MainTask.Reader.DirectoriesReader;
import com.epam.automation.JavaIO.MainTask.Reader.FilesReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesHandler {
    public void workWithFiles(File pathToFile) {
        FilesReader filesReader = new FilesReader();
        DirectoriesReader directoriesReader = new DirectoriesReader();

        Printer printer = new Printer();

        List<String> list = new ArrayList<>();

        try {
            list = filesReader.readFile(pathToFile);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        printer.printAmountDirectories(directoriesReader.getDirectoriesNumber(list));
        printer.printAmountFiles(filesReader.getFilesNumber(list));

        try {
            printer.printAverageQuantityFilesInDirectories(filesReader.getAverageFilesQuantityInDirectories(list));
        } catch (NoDirectoriesInPath e) {
            System.err.println(e.getMessage());
        }

        try {
            printer.printAverageLengthNameOfFiles(filesReader.getAverageLengthNameOfFiles(list));
        } catch (NoFilesInDirectories e) {
            System.err.println(e.getMessage());
        }
    }
}
