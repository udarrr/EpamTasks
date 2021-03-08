package com.epam.automation.javaio_stage2.maintask.console;

import com.epam.automation.javaio_stage2.maintask.console.handlers.DirectoriesHandler;
import com.epam.automation.javaio_stage2.maintask.console.handlers.FilesHandler;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    public void readPathOrFile() {
        Scanner scanner = new Scanner(System.in);

        Printer printer = new Printer();

        while (true) {
            printer.printDescriptionMenu();

            String inputLine = scanner.nextLine();
            String lineWithoutSpace = inputLine.trim();

            if (lineWithoutSpace.length() != 0) {
                File pathToFolderOrFile = new File(lineWithoutSpace);

                if (Files.isDirectory(Path.of(String.valueOf(pathToFolderOrFile)))) {
                    new DirectoriesHandler().workWithDirectories(pathToFolderOrFile);
                } else if (Files.isRegularFile(Path.of(String.valueOf(pathToFolderOrFile)))) {
                    new FilesHandler().workWithFiles(pathToFolderOrFile);
                } else {
                    System.err.println("Path isn't exist please try again");
                }
            } else {
                System.err.println("Blank line isn't path please try again");
            }
        }
    }
}


