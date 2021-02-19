package com.epam.automation.JavaIO.Console;

import com.epam.automation.JavaIO.Exception.NoDirectoriesInPath;
import com.epam.automation.JavaIO.Exception.NoFilesInDirectories;
import com.epam.automation.JavaIO.Reader;
import com.epam.automation.JavaIO.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Reader reader = new Reader();

    Writer writer = new Writer();

    Printer printer = new Printer();

    public void readPathOrFile() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printer.printDescriptionMenu();

            String path = scanner.nextLine();

            File enteredPath = new File(path);

            if (Files.isDirectory(Path.of(path))) {
                workWithDirectories(enteredPath);
            } else if (Files.isRegularFile(Path.of(String.valueOf(enteredPath)))) {
                workWithFiles(enteredPath);
            } else {
                System.out.println("Path is wrong");
            }
        }
    }

    private void workWithDirectories(File enteredPath) {
        try {
            writer.putLinesToFile(reader.getDirectoriesTree(enteredPath));
            printer.printPlaceWithResult();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void workWithFiles(File enteredPath) {
        List<String> list = new ArrayList<>();

        try {
            list = reader.readFile(enteredPath);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        printer.printAmountDirectories(reader.getAmountDirectories(list));
        printer.printAmountFiles(reader.getAmountFiles(list));

        try {
            printer.printAverageQuantityFilesInDirectories(reader.getAverageAmountFiles(list));
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


