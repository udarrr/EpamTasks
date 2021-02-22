package com.epam.automation.JavaIO.MainTask.Builder;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PathsBuilder {
    public String fillDirectoriesTree(File path) throws IOException {
        int jumpRecursion = 0;

        StringBuilder stringBuilder = new StringBuilder();

        Stack<Boolean> positionDirectory = new Stack<>();

        fillDirectoriesTree(path, jumpRecursion, stringBuilder, positionDirectory);

        return stringBuilder.toString();
    }

    private Boolean checkEndDirectory(Path path) throws IOException {
        Stack<Path> pathsDirectoriesInParentDirectory = new Stack<>();

        DirectoryStream<Path> parentDirectory = Files.newDirectoryStream(path.getParent());

        for (Path p : parentDirectory) {
            pathsDirectoriesInParentDirectory.add(p);
        }

        if (!pathsDirectoriesInParentDirectory.isEmpty() && pathsDirectoriesInParentDirectory.peek().equals(path)) {
            return false;
        } else {
            return true;
        }
    }

    private void fillDirectoriesTree(File path, int jumpRecursion, StringBuilder stringBuilder, Stack<Boolean> positionDirectory) throws IOException {
        stringBuilder.append(getStringAfterRecursion(positionDirectory));
        stringBuilder.append("+--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");

        if (jumpRecursion > 0) {
            positionDirectory.push(checkEndDirectory(path.toPath()));
        }

        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.isDirectory()) {
                fillDirectoriesTree(file, jumpRecursion + 1, stringBuilder, positionDirectory);
            } else {
                buildLineWithFile(file, stringBuilder, positionDirectory);
            }
        }

        if (!positionDirectory.isEmpty()) {
            positionDirectory.pop();
        }
    }

    private void buildLineWithFile(File path, StringBuilder stringBuilder, Stack<Boolean> positionDirectory) {
        stringBuilder.append(getStringAfterRecursion(positionDirectory));
        stringBuilder.append("\\--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");
    }

    private String getStringAfterRecursion(Stack<Boolean> positionDirectory) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Boolean> copiedStackPositionDirectory = (Stack<Boolean>) positionDirectory.clone();
        Stack<Boolean> reversedStack = reverseStack(copiedStackPositionDirectory);

        while (!reversedStack.isEmpty()) {
            if (reversedStack.peek()) {
                stringBuilder.append("|\u0020\u0020\u0020");
            }

            if (reversedStack.peek()) {
                stringBuilder.append("\u0020\u0020\u0020");
            }
            reversedStack.pop();
        }

        return stringBuilder.toString();
    }

    private Stack<Boolean> reverseStack(Stack<Boolean> stack) {
        Stack<Boolean> reversedStack = new Stack<>();

        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }

        return reversedStack;
    }
}
