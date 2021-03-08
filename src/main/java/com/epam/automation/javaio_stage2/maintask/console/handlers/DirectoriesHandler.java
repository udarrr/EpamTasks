package com.epam.automation.javaio_stage2.maintask.console.handlers;

import com.epam.automation.javaio_stage2.maintask.builders.PathsBuilder;
import com.epam.automation.javaio_stage2.maintask.console.Printer;
import com.epam.automation.javaio_stage2.maintask.writers.PathsToFileWriter;

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
