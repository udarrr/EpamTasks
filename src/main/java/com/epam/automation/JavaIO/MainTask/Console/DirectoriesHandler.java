package com.epam.automation.JavaIO.MainTask.Console;

import com.epam.automation.JavaIO.MainTask.Reader;
import com.epam.automation.JavaIO.MainTask.Writer;

import java.io.File;
import java.io.IOException;

public class DirectoriesHandler {
    public void workWithDirectories(File pathToDirectory) {
        Writer writer = new Writer();

        Printer printer = new Printer();

        Reader reader = new Reader();

        try {
            writer.putLinesToFile(reader.fillDirectoriesTree(pathToDirectory));
            printer.printPlaceWithResult();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
