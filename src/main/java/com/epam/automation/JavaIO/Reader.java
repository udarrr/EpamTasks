package com.epam.automation.JavaIO;

import com.epam.automation.JavaIO.Exception.NoDirectoriesInPath;
import com.epam.automation.JavaIO.Exception.NoFilesInDirectories;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Reader {
    public String getDirectoriesTree(File path) throws IOException {
        int jumpRecursion = 0;

        StringBuilder stringBuilder = new StringBuilder();

        Stack<Integer> isLast = new Stack<>();

        getDirectoriesTree(path, jumpRecursion, stringBuilder, isLast);

        return stringBuilder.toString();
    }

    private int isEndDirectory(Path path) throws IOException {
        Stack<Path> temporaryPath = new Stack<>();

        DirectoryStream<Path> directoryParent = Files.newDirectoryStream(path.getParent());

        for (Path p : directoryParent) {
            temporaryPath.add(p);
        }

        if (!temporaryPath.isEmpty() && temporaryPath.peek().equals(path)) {

            return 0;
        } else {

            return 1;
        }
    }

    private void getDirectoriesTree(File path, int jumpRecursion, StringBuilder stringBuilder, Stack<Integer> positionDirectory) throws IOException {
        stringBuilder.append(getStringAfterRecursion(positionDirectory));
        stringBuilder.append("+--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");

        if (jumpRecursion > 0) {
            positionDirectory.push(isEndDirectory(path.toPath()));
        }

        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.isDirectory()) {
                getDirectoriesTree(file, jumpRecursion + 1, stringBuilder, positionDirectory);
            } else {
                getFile(file, stringBuilder, positionDirectory);
            }
        }

        if (!positionDirectory.isEmpty()) {
            positionDirectory.pop();
        }
    }

    private void getFile(File path, StringBuilder stringBuilder, Stack<Integer> isLast) {
        stringBuilder.append(getStringAfterRecursion(isLast));
        stringBuilder.append("\\--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");
    }

    private String getStringAfterRecursion(Stack<Integer> positionDirectory) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> copyStackPositionDirectory = (Stack<Integer>) positionDirectory.clone();
        Stack<Integer> stack = reverseStack(copyStackPositionDirectory);

        while (!stack.isEmpty()) {
            if (stack.peek() == 1) {
                stringBuilder.append("|\u0020\u0020\u0020");
            }
            if (stack.peek() == 0) {
                stringBuilder.append("\u0020\u0020\u0020");
            }
            stack.pop();
        }

        return stringBuilder.toString();
    }

    private Stack<Integer> reverseStack(Stack<Integer> copyStackPositionDirectory) {
        Stack<Integer> reverseStack = new Stack<>();

        while (!copyStackPositionDirectory.isEmpty()) {
            reverseStack.push(copyStackPositionDirectory.pop());
        }

        return reverseStack;
    }

    public double getAmountDirectories(List<String> strings) {
        double amount = 0;

        for (String str : strings) {
            if (str.contains("+--")) {
                amount++;
            }
        }

        return amount;
    }

    public double getAmountFiles(List<String> strings) {
        double amount = 0;

        for (String str : strings) {
            if (str.contains("\\--")) {
                amount++;
            }
        }

        return amount;
    }

    public double getAverageAmountFiles(List<String> strings) throws NoDirectoriesInPath {
        if(getAmountDirectories(strings) != 0) {
            return getAmountFiles(strings) / getAmountDirectories(strings);
        } else {
            throw new NoDirectoriesInPath("There are no directories in path");
        }
    }

    private double getAmountLengthsFiles(List<String> strings) {
        double averageLength = 0;

        for (String str : getListFiles(strings)) {
            String[] splitedStr = str.split("\\\\--");
            if (splitedStr.length == 2) {
                String[] splittedFileNameAndExtention = splitedStr[1].split("\\.");
                averageLength += splittedFileNameAndExtention[0].length();
            }
        }

        return averageLength;
    }

    private List<String> getListFiles(List<String> strings) {
        List<String> listFiles = new ArrayList<>();

        for (String str : strings) {
            if (str.contains("\\--")) {
                listFiles.add(str);
            }
        }

        return listFiles;
    }

    public double getAverageLengthNameOfFiles(List<String> strings) throws NoFilesInDirectories {
        if (getAmountFiles(strings) != 0) {
            return getAmountLengthsFiles(strings) / getAmountFiles(strings);
        } else {
            throw new NoFilesInDirectories("There are no files in directories");
        }
    }

    public List<String> readFile(File path) throws IOException {
        List<String> listDirectoriesAndFiles = new LinkedList<>();

        BufferedReader in = new BufferedReader(new FileReader(path));

        String readiedLine;

        while ((readiedLine = in.readLine()) != null) {
            listDirectoriesAndFiles.add(readiedLine);
        }

        in.close();

        return listDirectoriesAndFiles;
    }
}
