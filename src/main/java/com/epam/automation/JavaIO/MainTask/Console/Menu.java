package com.epam.automation.JavaIO.MainTask.Console;

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

            File pathToFolderOrFile = new File(inputLine);

            if (Files.isDirectory(Path.of(String.valueOf(pathToFolderOrFile)))) {
                new DirectoriesHandler().workWithDirectories(pathToFolderOrFile);
            } else if (Files.isRegularFile(Path.of(String.valueOf(pathToFolderOrFile)))) {
                new FilesHandler().workWithFiles(pathToFolderOrFile);
            } else {
                System.err.println("Path is wrong");
            }
        }
    }
}


