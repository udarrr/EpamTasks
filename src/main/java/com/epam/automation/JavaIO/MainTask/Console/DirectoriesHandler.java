package com.epam.automation.JavaIO.MainTask.Console;

import com.epam.automation.JavaIO.MainTask.Builder.PathsBuilder;
import com.epam.automation.JavaIO.MainTask.Writer.PathsToFileWriter;

import java.io.File;
import java.io.IOException;

public class DirectoriesHandler {
    public void workWithDirectories(File pathToDirectory) {
        PathsToFileWriter pathsToFileWriter = new PathsToFileWriter();

        Printer printer = new Printer();

        PathsBuilder pathsBuilder = new PathsBuilder();

        try {
            pathsToFileWriter.putLinesToFile(pathsBuilder.fillDirectoriesTree(pathToDirectory));
            printer.printPlaceWithResult();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
