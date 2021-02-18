package com.epam.automation.JavaIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Stack;

public class ConsolePrinter {

    public static String printDirectoryTree(File folder) throws IOException {

        int jumpRecursion = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> isLast = new Stack<>();

        printDirectoryTree(folder, jumpRecursion, sb, isLast);
        return sb.toString();
    }

    private static int getQuantityDirectories(Path path) throws IOException {
        int quantity = 0;

        DirectoryStream<Path> directories = Files.newDirectoryStream(path);

        for (Path amount : directories) {
            if (Files.isDirectory(amount)) {
                quantity++;
            }
        }

        if (quantity > 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void printDirectoryTree(File folder, int jumpRecursion, StringBuilder sb, Stack<Integer> isLast) throws IOException {

        sb.append(getStringAfterRecursion(jumpRecursion, isLast));
        sb.append("|--");
        sb.append(folder.getName());
        sb.append("\n");

        isLast.push(getQuantityDirectories(folder.toPath()));

        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                printDirectoryTree(file, jumpRecursion + 1, sb, isLast);
            } else {
                printFile(file, jumpRecursion + 1, sb, isLast);
            }
        }

        if(!isLast.isEmpty()) {
            isLast.pop();
        }
    }

    private static void printFile(File file, int jumpRecursion, StringBuilder sb, Stack<Integer> isLast) {
        sb.append(getStringAfterRecursion(jumpRecursion, isLast));
        sb.append("|--");
        sb.append(file.getName());
        sb.append("\n");
    }

    private static String getStringAfterRecursion(int jumpRecursion, Stack<Integer> isLast) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> temp = (Stack<Integer>) isLast.clone();
        Stack<Integer> newTemp = new Stack<>();

        while (!temp.isEmpty()){
            newTemp.push(temp.pop());
        }

        while (!newTemp.isEmpty()) {
            if (newTemp.peek() == 1) {
                sb.append("|***");
            }
            if (newTemp.peek() == 0) {
                sb.append("****");
            }
            newTemp.pop();
        }

        return sb.toString();
    }
}
