package com.epam.automation.JavaIO.MainTask.Consoles;

import com.epam.automation.JavaIO.MainTask.Builders.PathsBuilder;
import com.epam.automation.JavaIO.MainTask.Writers.PathsToFileWriter;

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
